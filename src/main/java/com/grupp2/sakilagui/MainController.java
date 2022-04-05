package com.grupp2.sakilagui;

import com.grupp2.sakilagui.bs.Customer;
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

import javax.persistence.*;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    //Main Tab Pane
    @FXML private TabPane mainTabPane;

    //Tabs
    @FXML private Tab tabActor;
    @FXML private Tab tabAddress;
    @FXML private Tab tabCategory;
    @FXML private Tab tabCity;
    @FXML private Tab tabCountry;
    @FXML private Tab tabCustomer;
    @FXML private Tab tabFilm;
    @FXML private Tab tabFilmActor;
    @FXML private Tab tabFilmCategory;
    @FXML private Tab tabFilmText;
    @FXML private Tab tabInventory;
    @FXML private Tab tabLanguage;
    @FXML private Tab tabPayment;
    @FXML private Tab tabStaff;
    @FXML private Tab tabStore;

    //Rental
    @FXML private Tab tabRental;
    @FXML private TableView<Rental> tableRental;
    @FXML private TableColumn<Rental, Integer> colRental_Id;
    @FXML private TableColumn<Rental, Date> colRental_date;
    @FXML private TableColumn<Rental, Inventory> colRental_inventoryId;
    @FXML private TableColumn<Rental, Customer> colRental_customerId;
    @FXML private TableColumn<Rental, Date> colRental_returnDate;
    @FXML private TableColumn<Rental, Staff> colRental_staffId;
    @FXML private TableColumn<Rental, Date> colRental_lastUpdate;
    private ObservableList<Rental> rentalObservableList = FXCollections.observableArrayList();

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    public void readFromRental(){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            //
            transaction = entityManager.getTransaction();
            transaction.begin();

            List<Rental> rentalList = entityManager.createQuery("SELECT r FROM Rental r LEFT JOIN FETCH r.inventoryId", Rental.class).getResultList();
            rentalList = entityManager.createQuery("SELECT r FROM Rental r LEFT JOIN FETCH r.customerId", Rental.class).getResultList();
            rentalList = entityManager.createQuery("SELECT r FROM Rental r LEFT JOIN FETCH r.staffId", Rental.class).getResultList();


            colRental_Id.setCellValueFactory(new PropertyValueFactory<>("rentalId"));
            colRental_date.setCellValueFactory(new PropertyValueFactory<>("rentalDate"));
            colRental_inventoryId.setCellValueFactory(new PropertyValueFactory<>("inventoryId"));
            colRental_customerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
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
        readFromRental();
    }
}