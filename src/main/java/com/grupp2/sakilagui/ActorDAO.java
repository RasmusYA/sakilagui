package com.grupp2.sakilagui;

import com.grupp2.sakilagui.bs.Actor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

public class ActorDAO {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    public List<Actor> readTable(){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        List<Actor> list = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Query query = entityManager.createNativeQuery("SELECT * FROM actor WHERE actor_id > 11 AND actor_id < 15", Actor.class);

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

    public void showTableConsole(List<Actor> list){

        for (Actor actor : list){
            System.out.print("Actor Id: " + actor.getActorId());
            System.out.print("  First name : " + actor.getFirstName());
            System.out.print("  Last name : " + actor.getLastName());
            System.out.println("  Last update : " + actor.getLastUpdate());
        }
    }

    public void insertObject(Actor actor){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(actor);

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

    public void updateObject(Actor actorUp, int id){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Actor actor = entityManager.find(Actor.class, id);
            actor.setFirstName(actorUp.getFirstName());
            actor.setLastName(actorUp.getLastName());
            actor.setLastUpdate(Timestamp.from(Instant.now()));

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

    public void removeObject(int id){
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Cascade doesn't work, it gives error, so first child table data has to be deleted.
            Query query = entityManager.createNativeQuery("DELETE FROM film_actor WHERE actor_id = ?");
            query.setParameter(1, id);
            query.executeUpdate();

            query = entityManager.createNativeQuery("DELETE FROM actor WHERE actor_Id = ?");
            query.setParameter(1, id);
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

    public static void main(String[] args) {

        ActorDAO dao = new ActorDAO();

//        System.out.println(" Show table: ");
//        dao.showTableConsole(dao.readTable());
//
//        System.out.println(" Insert object: ");
//        Actor actor = new Actor();
//        actor.setFirstName("aaaa");
//        actor.setLastName("bbbb");
//        actor.setLastUpdate(Timestamp.from(Instant.now()));
//        dao.insertObject(actor);
//        dao.showTableConsole(dao.readTable());
//
//        System.out.println(" Update object: ");
//        actor.setFirstName("cccc");
//        actor.setLastName("dddd");
//        dao.updateObject(actor, 201);
//        dao.showTableConsole(dao.readTable());
//
        dao.showTableConsole(dao.readTable());
        System.out.println(" Remove object: ");
        dao.removeObject(13);
        dao.showTableConsole(dao.readTable());

    }
}
