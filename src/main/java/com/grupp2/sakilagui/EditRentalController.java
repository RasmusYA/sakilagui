package com.grupp2.sakilagui;

import com.grupp2.sakilagui.bs.Actor;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.net.URL;
import java.util.ResourceBundle;

public class EditRentalController implements Initializable {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");
    
    @FXML private Button closeButton;

    @FXML private TextField actorFirstName;
//    @FXML private CheckBox isInsideCheckBox;
//    @FXML private ComboBox<Address> arenaComboBox;

    @FXML private Actor selectedActor;

    public Actor getSelectedActor() {
        return selectedActor;
    }

    public void setSelectedActor(Actor selectedActor)  {
        this.selectedActor = selectedActor;
        actorFirstName.setText(selectedActor.getFirstName());
//        isInsideCheckBox.setSelected(selectedArena.getIsInside());
//        arenaComboBox.setValue(selectedArena.getAddress());
    }

    @FXML
    private void closeWindow(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void saveArenaWindow(){
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = em.getTransaction();
            transaction.begin();

            Actor actor = em.find(Actor.class, getSelectedActor().getActorId());
            actor.setFirstName(actorFirstName.getText());
//            arena.setInside(isInsideCheckBox.isSelected());
//            arena.setAddress(arenaComboBox.getValue());
//            arena.setInside(isInsideCheckBox.isSelected());
            em.getTransaction().commit();
            closeWindow();
        } catch(Exception ex){
            if (transaction != null) {
                transaction.rollback();
                System.out.println(ex);
            }
        } finally{
            em.close();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
//        EntityTransaction transaction = null;
//        try {
//            transaction = em.getTransaction();
//            transaction.begin();
//
//            List<Address> comboBoxList = em.createNativeQuery("SELECT * FROM address", Address.class).getResultList();
//            arenaComboBox.getItems().addAll(comboBoxList);
//            arenaComboBox.setCellFactory(lc -> new ListCell<>(){
//                @Override
//                protected void updateItem(Address address, boolean empty) {
//                    super.updateItem(address, empty);
//                    if (empty || address == null) {
//                        setText(null);
//                    } else {
//                        setText(address.getStreetName() + " " + address.getStreetNumber());
//                    }
//                }
//            });
//            arenaComboBox.setButtonCell( new ListCell<>(){
//                @Override
//                protected void updateItem(Address address, boolean empty) {
//                    super.updateItem(address, empty);
//                    if (empty || address == null) {
//                        setText(null);
//                    } else {
//                        setText(address.getStreetName() + " " + address.getStreetNumber());
//                    }
//                }
//            });
//            transaction.commit();
//        } catch (Exception ex) {
//            if (transaction != null)
//                transaction.rollback();
//        } finally {
//            em.close();
//        }
    }
}
