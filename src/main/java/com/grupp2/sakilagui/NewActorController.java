package com.grupp2.sakilagui;

import com.grupp2.sakilagui.bs.Actor;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NewActorController {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");
    @FXML private Button closeButton;

    @FXML private TextField actorFirstName;
    @FXML private TextField actorLastName;
    @FXML private TextField actorLastUpdate;

    @FXML
    private void closeButton() {
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

            Actor actor = new Actor();
            actor.setFirstName(actorFirstName.getText());
            actor.setLastName(actorLastName.getText());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            actor.setLastUpdate(date);

            em.persist(actor);
            em.getTransaction().commit();

            closeButton();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            em.close();
        }
    }
}
