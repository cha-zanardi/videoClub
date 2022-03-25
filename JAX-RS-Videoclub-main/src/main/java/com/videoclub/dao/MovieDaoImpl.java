package com.videoclub.dao;

import com.videoclub.dao.base.MovieDao;
import com.videoclub.dao.entity.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieDaoImpl implements MovieDao {

    @Override
    public Long save(Movie object) {
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
    public List<Movie> findAll() {
        List<Movie> movies = new ArrayList<>();
        EntityManager em = DaoFactory.getEmf().createEntityManager();
        Query query = em.createQuery("from Movie ");
        movies = query.getResultList();
        em.close();
        return movies;
    }

    @Override
    public Optional<Movie> findById(Long aLong) {
        EntityManager em = null;
        List<Movie> movie = null;

        try {
            em = DaoFactory.getEmf().createEntityManager();
            Query query = em.createQuery("from Movie where id = :id");
            query.setParameter("id", aLong);
            movie =  query.getResultList();


        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return movie.stream().findFirst();
    }

    @Override
    public boolean update(Movie object) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        Movie movie = null;

        try {
            em =  DaoFactory.getEmf().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();

            movie = em.merge(object);

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
