package com.grupp2.sakilagui;

import com.grupp2.sakilagui.bs.Customer;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


public class CustomerDAO {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    public List<Customer> readTable(){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        List<Customer> list = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Query query = entityManager.createQuery("SELECT c FROM Customer c LEFT JOIN FETCH c.storeId", Customer.class);
            list = query.getResultList();
            query = entityManager.createQuery("SELECT c FROM Customer c LEFT JOIN FETCH c.addressId", Customer.class);
            list = query.getResultList();

            transaction.commit();

        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
        return list;
    }


}

