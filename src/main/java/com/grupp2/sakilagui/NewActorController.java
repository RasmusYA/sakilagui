package edu.petersson.wigelltravels.controllers;

import edu.petersson.wigelltravels.Address;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class NewAddressController {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");
    @FXML
    private Button closeButton;

    @FXML private TextField streetNameLabel;
    @FXML private TextField streetNumberLabel;
    @FXML private TextField postCodeLabel;
    @FXML private TextField townLabel;

    @FXML
    private void closeWindowButton() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void saveButton() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = em.getTransaction();
            transaction.begin();

            Address address = new Address();
            address.setStreetName(streetNameLabel.getText());
            address.setStreetNumber(streetNumberLabel.getText());
            address.setPostCode(postCodeLabel.getText());
            address.setTown(townLabel.getText());

            em.persist(address);
            em.getTransaction().commit();

            closeWindowButton();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            em.close();
        }
    }
}
