package com.videoclub.dao;

import com.videoclub.dao.base.ActorDao;
import com.videoclub.dao.entity.Actor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ActorDaoImpl implements ActorDao {

    @Override
    public Long save(Actor object) {
        EntityManager em = null;
        EntityTransaction transaction = null;

        try {
            em = DaoFactory.getEmf().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();

            em.persist(object);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return 0L;
    }

    @Override
    public List<Actor> findAll() {
        List<Actor> actors = new ArrayList<>();
        EntityManager em = DaoFactory.getEmf().createEntityManager();
        Query query = em.createQuery("from Actor ");
        actors = query.getResultList();
        em.close();
        return actors;
    }

    @Override
    public Optional<Actor> findById(Long aLong) {
        EntityManager em = null;
        List<Actor> actor = null;

        try {
            em = DaoFactory.getEmf().createEntityManager();
            Query query = em.createQuery("from Actor where id = :id");
            query.setParameter("id", aLong);
            actor =  query.getResultList();


        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return actor.stream().findFirst();
    }

    @Override
    public boolean update(Actor object) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        Actor actor = null;

        try {
            em =  DaoFactory.getEmf().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();

            actor = em.merge(object);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
        return true;
    }

    @Override
    public void delete(Long aLong) {
        EntityManager em = null;
        EntityTransaction transaction = null;

        try {
            em = DaoFactory.getEmf().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();

            em.remove(findById(aLong));

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
