package com.grupp2.sakilagui;

import com.grupp2.sakilagui.bs.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class NewRentalController implements Initializable {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    @FXML private Button closeButton;

    @FXML private DatePicker rentalRentalDate;
    @FXML private TextField rentalInventoryId;
    @FXML private TextField rentalCustomerId;
    @FXML private DatePicker rentalReturnDate;
    @FXML private TextField rentalStaffId;

    @FXML private Rental selectedRental;

    public Rental getSelectedRental() {
        return selectedRental;
    }

    public void setSelectedRental(Rental selectedRental)  {
        this.selectedRental = selectedRental;
        rentalRentalDate.setValue(selectedRental.getRentalDate().toLocalDate());
        rentalInventoryId.setText(Integer.toString((selectedRental.getInventoryId().getInventoryId())));
        rentalCustomerId.setText(Integer.toString((selectedRental.getCustomerId().getCustomerId())));
        rentalReturnDate.setValue(selectedRental.getReturnDate().toLocalDate());
        rentalStaffId.setText(Integer.toString((selectedRental.getStaffId().getStaffId())));
    }

    @FXML
    private void closeWindow(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void saveRental(){
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = em.getTransaction();
            transaction.begin();

            Rental rental = new Rental();
            rental.setRentalDate(Date.valueOf(rentalRentalDate.getValue()));
            Inventory inventory = em.find(Inventory.class, Integer.parseInt(rentalInventoryId.getText()));
            rental.setInventoryId(inventory);
            Customer customer = em.find(Customer.class, Integer.parseInt(rentalCustomerId.getText()));
            rental.setCustomerId(customer);
            rental.setReturnDate(Date.valueOf(rentalReturnDate.getValue()));
            Staff staff = em.find(Staff.class, Integer.parseInt(rentalStaffId.getText()));
            rental.setStaffId(staff);
            em.persist(rental);

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
