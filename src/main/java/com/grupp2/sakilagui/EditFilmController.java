package com.grupp2.sakilagui;

import com.grupp2.sakilagui.bs.Film;
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

public class EditFilmController implements Initializable {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");
    
    @FXML private Button closeButton;


    @FXML private TextField filmTitle;
    @FXML private TextField filmDescription;
    @FXML private TextField filmReleaseYear;
    @FXML private TextField filmLanguage;
    @FXML private TextField filmOriginalLanguage;
    @FXML private TextField filmRentalDuration;
    @FXML private TextField filmRating;
    @FXML private TextField filmLength;
    @FXML private TextField filmReplacementCost;
    @FXML private TextField filmRentalRate;
    @FXML private TextField filmSpecialFeatures;
    @FXML private TextField filmLastUpdate;

    @FXML private Film selectedFilm;

    public Film getSelectedFilm() {
        return selectedFilm;
    }

    public void setSelectedFilm(Film selectedFilm)  {
        this.selectedFilm = selectedFilm;
        filmTitle.setText(selectedFilm.getTitle());
        filmDescription.setText(selectedFilm.getDescription());
        filmReleaseYear.setText(String.valueOf(selectedFilm.getReleaseYear()));
        filmLanguage.setText(String.valueOf(selectedFilm.getLanguageId()));
        filmOriginalLanguage.setText(String.valueOf(selectedFilm.getOriginalLanguageId()));
        filmRentalDuration.setText(String.valueOf(selectedFilm.getRentalDuration()));
        filmRating.setText(selectedFilm.getRating());
        filmLength.setText(String.valueOf(selectedFilm.getLength()));
        filmReplacementCost.setText(String.valueOf(selectedFilm.getReplacementCost()));
        filmRentalRate.setText(String.valueOf(selectedFilm.getRentalRate()));
        filmSpecialFeatures.setText(selectedFilm.getSpecialFeatures());
        filmLastUpdate.setText(selectedFilm.getLastUpdate().toString());

    }

    @FXML
    private void closeWindow(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void saveFilm(){
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = em.getTransaction();
            transaction.begin();

            Film film = em.find(Film.class, getSelectedFilm().getFilmId());
            film.setTitle(filmTitle.getText());
            film.setDescription(filmDescription.getText());
            film.setReleaseYear(Integer.parseInt(filmReleaseYear.getText()));
            //film.setLanguageId(Integer.parseInt(filmLanguage.getText()));
            //film.setOriginalLanguageId(Integer.parseInt(filmLanguage.getText()));
            film.setRentalDuration(Integer.parseInt(filmRentalDuration.getText()));
            film.setRating(filmRating.getText());
            film.setLength(Integer.parseInt(filmLength.getText()));
            film.setReplacementCost(Double.parseDouble(filmReplacementCost.getText()));

            film.setRentalRate(Double.parseDouble(filmRentalRate.getText()));
            film.setSpecialFeatures(filmSpecialFeatures.getText());
            //film.setLastUpdate(filmLastUpdate.getText());


            em.getTransaction().commit();
            closeWindow();
        } catch(Exception ex){
            if (transaction != null) {
                transaction.rollback();
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
