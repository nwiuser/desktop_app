package com.ex.appdesktop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class HomeController {
    @FXML
    private ListView<String> servicesListView;

    private final ObservableList<String> services = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Initialisation des données dans la liste
        services.addAll("Service 1", "Service 2", "Service 3");
        servicesListView.setItems(services);
    }

    @FXML
    private void handleAddService() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Ajouter un Service");
        dialog.setHeaderText("Ajoutez un nouveau service");
        dialog.setContentText("Nom du service :");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(serviceName -> {
            if (!serviceName.trim().isEmpty()) {
                services.add(serviceName.trim());
            } else {
                showAlert("Le nom du service ne peut pas être vide.");
            }
        });
    }

    @FXML
    private void handleDeleteService() {
        String selectedService = servicesListView.getSelectionModel().getSelectedItem();
        if (selectedService != null) {
            services.remove(selectedService);
        } else {
            showAlert("Veuillez sélectionner un service à supprimer.");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING, message, ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}
