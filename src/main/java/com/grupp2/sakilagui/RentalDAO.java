package com.grupp2.sakilagui;

import com.grupp2.sakilagui.bs.Rental;

import javax.persistence.*;
import java.util.List;

public class RentalDAO {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");
    EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
    EntityTransaction transaction = null;

    public void removeObject(int id){
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Query query = entityManager.createNativeQuery("DELETE FROM rental WHERE rental_id = 'id'");
            query.executeUpdate();

            transaction.commit();

        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }

    public void getAll(){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

//            Query query = entityManager.createNativeQuery("SELECT rental_id FROM rental");
//            List<Object[]> authorObject = query.getResultList();
//            for(Object[] o : authorObject) {
//                System.out.println(o[2] + " " + o[0] + " " + o[1]);
//                //System.out.println("Rasmus Test: " + o);
//            }

            List<Rental> rentalList = entityManager.createNativeQuery("SELECT * FROM rental LIMIT 10", Rental.class).getResultList();
            System.out.println(rentalList);

            transaction.commit();

        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }

}
