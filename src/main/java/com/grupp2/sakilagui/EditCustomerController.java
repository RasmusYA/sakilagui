package com.grupp2.sakilagui;

import com.grupp2.sakilagui.bs.Actor;
import com.grupp2.sakilagui.bs.Customer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.net.URL;
import java.util.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;

public class EditCustomerController implements Initializable {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;

    @FXML private DatePicker datePicker;
    @FXML private ComboBox addressBomboBox;

    @FXML private Button closeButton;
    @FXML private Button saveButton;

//    @FXML private CheckBox isInsideCheckBox;
//    @FXML private ComboBox<Address> arenaComboBox;

    @FXML private Customer selectedCustomer;

    public Customer getSelectedCustomer() {
        return selectedCustomer;
    }

    public void setSelectedCustomer(Customer selectedCustomer)  {
        this.selectedCustomer = selectedCustomer;
        firstNameField.setText(selectedCustomer.getFirstName());
        lastNameField.setText(selectedCustomer.getLastName());

        // Setting the datepicker which requires converting Date to LocalDate:
        LocalDate customerCreateDate = Instant.ofEpochMilli(selectedCustomer.getCreateDate().getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        datePicker.setValue(customerCreateDate);

//        isInsideCheckBox.setSelected(selectedArena.getIsInside());
//        arenaComboBox.setValue(selectedArena.getAddress());
    }

    @FXML
    private void closeWindow(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void saveWindow(){
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = em.getTransaction();
            transaction.begin();

            Customer customer = em.find(Customer.class, getSelectedCustomer().getCustomerId());

            customer.setFirstName(firstNameField.getText());
            customer.setLastName(lastNameField.getText());

            Date date = Date.from(datePicker.getValue().atStartOfDay()
                    .atZone(ZoneId.systemDefault())
                    .toInstant());

            customer.setCreateDate(date);
            customer.setFirstName(firstNameField.getText());
            customer.setFirstName(firstNameField.getText());
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
