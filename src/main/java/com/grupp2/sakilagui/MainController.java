package com.grupp2.sakilagui;

import com.grupp2.sakilagui.bs.Inventory;
import com.grupp2.sakilagui.bs.Rental;
import com.grupp2.sakilagui.bs.Staff;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    //Main Tab Pane
    @FXML private TabPane mainTabPane;

    //Rental
    @FXML private Tab tabRental;
    @FXML private TableView<Rental> tableRental;
    @FXML private TableColumn<Rental, Integer> colRental_Id;
    @FXML private TableColumn<Rental, Inventory> colRental_inventoryId;
    @FXML private TableColumn<Rental, Date> colRental_date;
    //@FXML private TableColumn<Rental, Customer> colRental_customerId;
    @FXML private TableColumn<Rental, Date> colRental_returnDate;
    @FXML private TableColumn<Rental, Staff> colRental_staffId;
    @FXML private TableColumn<Rental, Date> colRental_lastUpdate;
    private ObservableList<Rental> rentalObservableList = FXCollections.observableArrayList();

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    public void readFromRental(){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            List<Rental> rentalList = entityManager.createNativeQuery("SELECT * FROM rental LIMIT 10", Rental.class).getResultList();
            colRental_Id.setCellValueFactory(new PropertyValueFactory<>("rentalId"));
            colRental_inventoryId.setCellValueFactory(new PropertyValueFactory<>("rentalDate"));
            colRental_date.setCellValueFactory(new PropertyValueFactory<>("inventoryId"));
            //colRental_customerId.setCellValueFactory(new PropertyValueFactory<>("postCode"));
            colRental_returnDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
            colRental_staffId.setCellValueFactory(new PropertyValueFactory<>("staffId"));
            colRental_lastUpdate.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

            rentalObservableList.addAll(rentalList);
            tableRental.setItems(rentalObservableList);

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null)
                transaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}