package com.videoclub.dao;

import com.videoclub.dao.base.TagDao;
import com.videoclub.dao.entity.Tag;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TagDaoImpl implements TagDao {

    @Override
    public Long save(Tag object) {
        EntityManager       em = null;
        EntityTransaction   transaction = null;

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
    public List<Tag> findAll() {
        List<Tag> tags = new ArrayList<>();
        EntityManager em = DaoFactory.getEmf().createEntityManager();
        Query query = em.createQuery("from Tag ");
        tags = query.getResultList();
        em.close();
        return tags;
    }

    @Override
    public Optional<Tag> findById(Long aLong) {
        EntityManager   em = null;
        List<Tag>       tags = null;

        try {
            em = DaoFactory.getEmf().createEntityManager();
            Query query = em.createQuery("from Tag where id = :id");
            query.setParameter("id", aLong);
            tags =  query.getResultList();


        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return tags.stream().findFirst();
    }

    @Override
    public boolean update(Tag object) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        Tag tag = null;

        try {
            em =  DaoFactory.getEmf().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();

            tag = em.merge(object);

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
