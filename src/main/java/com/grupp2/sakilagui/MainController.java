package com.grupp2.sakilagui;

import com.grupp2.sakilagui.bs.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

    //Menu
    @FXML private MenuItem exitMenuButton;

    //Main Tab Pane
    @FXML private TabPane mainTabPane;

    //Tabs
    @FXML private Tab tabAddress;
    @FXML private Tab tabCategory;
    @FXML private Tab tabCity;
    @FXML private Tab tabCountry;
    @FXML private Tab tabFilmActor;
    @FXML private Tab tabFilmCategory;
    @FXML private Tab tabFilmText;
    @FXML private Tab tabInventory;
    @FXML private Tab tabLanguage;
    @FXML private Tab tabPayment;
    @FXML private Tab tabStaff;
    @FXML private Tab tabStore;

    //Actor
    @FXML private Tab tabActor;
    @FXML private TableView<Actor> tableActor;
    @FXML private TableColumn<Actor, Integer> colActor_actorId;
    @FXML private TableColumn<Actor, String> colActor_firstName;
    @FXML private TableColumn<Actor, String> colActor_lastName;
    @FXML private TableColumn<Actor, Date> colActor_lastUpdate;
    private ObservableList<Actor> actorObservableList = FXCollections.observableArrayList();

    //Customer
    @FXML private Tab tabCustomer;
    @FXML private TableView<Customer> tableCustomer;
    @FXML private TableColumn<Customer, Integer> colCustomer_customerId;
    @FXML private TableColumn<Customer, Store> colCustomer_storeId;
    @FXML private TableColumn<Customer, String> colCustomer_firstName;
    @FXML private TableColumn<Customer, String> colCustomer_lastName;
    @FXML private TableColumn<Customer, String> colCustomer_email;
    @FXML private TableColumn<Customer, Address> colCustomer_addressId;
    @FXML private TableColumn<Customer, Boolean> colCustomer_active;
    @FXML private TableColumn<Customer, Date> colCustomer_createDate;
    @FXML private TableColumn<Customer, Date> colCustomer_lastUpdate;
    private ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();

    //Film
    @FXML private Tab tabFilm;
    @FXML private TableView<Film> tableFilm;
    @FXML private TableColumn<Film, Integer> colFilm_filmId;
    @FXML private TableColumn<Film, String> colFilm_title;
    @FXML private TableColumn<Film, String> colFilm_description;
    @FXML private TableColumn<Film, Integer> colFilm_releaseYear;
    @FXML private TableColumn<Film, Language> colFilm_languageId;
    @FXML private TableColumn<Film, Language> colFilm_originalLanguageId;
    @FXML private TableColumn<Film, Integer> colFilm_rentalDuration;
    @FXML private TableColumn<Film, Double> colFilm_rentalRate;
    @FXML private TableColumn<Film, Integer> colFilm_Length;
    @FXML private TableColumn<Film, Double> colFilm_replacementCost;
    @FXML private TableColumn<Film, Enum> colFilm_rating;
    @FXML private TableColumn<Film, Enum> colFilm_specialFeatures;
    @FXML private TableColumn<Film, Date> colFilm_lastUpdate;
    private ObservableList<Film> filmObservableList = FXCollections.observableArrayList();

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
    EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
    EntityTransaction transaction = null;

    public void readFromRental(){
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

    public void readFromActor() {
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            List<Actor> actorList = entityManager.createNativeQuery("SELECT * FROM actor", Actor.class).getResultList();

            colActor_actorId.setCellValueFactory(new PropertyValueFactory<>("actorId"));
            colActor_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            colActor_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            colActor_lastUpdate.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

            actorObservableList.addAll(actorList);
            tableActor.setItems(actorObservableList);

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null)
                transaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    public void readFromCustomer() {
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            List<Customer> customerList = entityManager.createQuery("SELECT c FROM Customer c LEFT JOIN FETCH c.storeId", Customer.class).getResultList();
            customerList = entityManager.createQuery("SELECT c FROM Customer c LEFT JOIN FETCH c.addressId", Customer.class).getResultList();

            colCustomer_customerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
            colCustomer_storeId.setCellValueFactory(new PropertyValueFactory<>("storeId"));
            colCustomer_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            colCustomer_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            colCustomer_email.setCellValueFactory(new PropertyValueFactory<>("email"));
            colCustomer_addressId.setCellValueFactory(new PropertyValueFactory<>("addressId"));
            colCustomer_active.setCellValueFactory(new PropertyValueFactory<>("active"));
            colCustomer_createDate.setCellValueFactory(new PropertyValueFactory<>("createDate"));
            colCustomer_lastUpdate.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

            customerObservableList.addAll(customerList);
            tableCustomer.setItems(customerObservableList);

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null)
                transaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    public void readFromFilm(){
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            List<Film> filmList = entityManager.createQuery("SELECT f FROM Film f LEFT JOIN FETCH f.languageId", Film.class).getResultList();
            filmList = entityManager.createQuery("SELECT f FROM Film f LEFT JOIN FETCH f.originalLanguageId", Film.class).getResultList();

            colFilm_filmId.setCellValueFactory(new PropertyValueFactory<>("filmId"));
            colFilm_title.setCellValueFactory(new PropertyValueFactory<>("title"));
            colFilm_description.setCellValueFactory(new PropertyValueFactory<>("description"));
            colFilm_releaseYear.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));
            colFilm_languageId.setCellValueFactory(new PropertyValueFactory<>("languageId"));
            colFilm_originalLanguageId.setCellValueFactory(new PropertyValueFactory<>("originalLanguageId"));
            colFilm_rentalDuration.setCellValueFactory(new PropertyValueFactory<>("rentalDuration"));
            colFilm_rentalRate.setCellValueFactory(new PropertyValueFactory<>("rentalRate"));
            colFilm_Length.setCellValueFactory(new PropertyValueFactory<>("length"));
            colFilm_replacementCost.setCellValueFactory(new PropertyValueFactory<>("replacementCost"));
            colFilm_rating.setCellValueFactory(new PropertyValueFactory<>("rating"));
            colFilm_specialFeatures.setCellValueFactory(new PropertyValueFactory<>("specialFeatures"));
            colFilm_lastUpdate.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));

            filmObservableList.addAll(filmList);
            tableFilm.setItems(filmObservableList);

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null)
                transaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    public void quitApplication() {
        exitMenuButton.setOnAction((ActionEvent t) -> {
            System.exit(0);
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //readFromRental();
    }
}