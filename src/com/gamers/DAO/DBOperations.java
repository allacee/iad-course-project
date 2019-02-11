package com.gamers.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.ParameterExpression;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class DBOperations
{

    private static String username;
    private static String password;

    public DBOperations()
    {
    }


    public DBOperations(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public static void setUsernameAndPassword(String user, String passwwrd)
    {
        username = user;
        password = passwwrd;
    }

    public void createEntity(Object entity)
    {

        operationWithoutResult(em ->
        {
            em.persist(entity);
        });
    }

    public void updateEntity(Object entity)
    {
        operationWithoutResult(em-> em.merge(entity));
    }


    public void deleteEntity(Object entity)
    {
        operationWithoutResult(em -> 
        {
            if(em.contains(entity))
                em.remove(entity);
            else
                em.remove(em.merge(entity));
        });
    }

    public Object findEntityById(Class entityClass, long id)
    {
        return operationWithResult(entityManager -> entityManager.find(entityClass, id));
    }

    public Object findEntityByObjectId(Class entityClass, Object id)
    {
        return operationWithResult(entityManager -> entityManager.find(entityClass, id));
    }

    public static<T> List<T> selectAll(Class<T> entityClass)
    {
        List<T> result = operationWithResult(entityManager ->
        {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
            Root<T> from = criteriaQuery.from(entityClass);
            
            CriteriaQuery<T> select = criteriaQuery.select(from);
            TypedQuery<T> typedQuery = entityManager.createQuery(select);

            return typedQuery.getResultList();
        });

        return result;
    }

    public static<T,P> List<T> queryWithCondition(Class<T> entityClass, Class<P> parameterClass,  P parameter, String parameterName)
    {
        List<T> result = operationWithResult(entityManager -> 
        {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

            CriteriaQuery<T> query = criteriaBuilder.createQuery(entityClass);
            Root<T> root = query.from(entityClass);
            ParameterExpression parameterExpression = criteriaBuilder.parameter(parameterClass);
            query.select(root).where(criteriaBuilder.equal(root.get(parameterName), parameterExpression));
            
            TypedQuery<T> typedQuery = entityManager.createQuery(query);
            typedQuery.setParameter(parameterExpression, parameter);

            return typedQuery.getResultList();

            
        });

        return result;
    }
    
    public static<T,P1, P2> List<T> queryWithTwoConditions(Class<T> entityClass, Class<P1> parameterClass1, Class<P2> parameterClass2,
                                              P1 parameter1, P2 parameter2, String parameter1Name, String parameter2Name)
    {
        List<T> result = operationWithResult(entityManager ->
        {

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

            CriteriaQuery<T> query = criteriaBuilder.createQuery(entityClass);
            Root<T> root = query.from(entityClass);
            ParameterExpression parameterExpression1 = criteriaBuilder.parameter(parameterClass1);
            ParameterExpression parameterExpression2 = criteriaBuilder.parameter(parameterClass2);

            query.select(root).where(criteriaBuilder.equal(root.get(parameter1Name), parameterExpression1), 
                                        criteriaBuilder.equal(root.get(parameter2Name), parameterExpression2));

            TypedQuery<T> typedQuery = entityManager.createQuery(query);
            typedQuery.setParameter(parameterExpression1, parameter1);
            typedQuery.setParameter(parameterExpression2, parameter2);

            return typedQuery.getResultList();
        });

        return result;
    }

    public static<T> List<T> nativeQuery(String query, Class<T> entityClass)
    {
        return operationWithResult(entityManager -> 
        { 
           return  entityManager.createNativeQuery(query, entityClass).getResultList();
        });
    }

    public static void nativeQueryUpdates(String updateQuery)
    {
        operationWithoutResult(entityManager ->
        {
            entityManager.createNativeQuery(updateQuery).executeUpdate();
        });
    }

    private static void operationWithoutResult(Consumer<EntityManager> operation)
    {
        EntityManagerFactory entityManagerFactory = PersistenceManager.getInstance().getEntityManagerFactory(username, password);

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        operation.accept(entityManager);

        entityManager.getTransaction().commit();

        entityManager.close();
    }

    private static<T> T operationWithResult( Function<EntityManager, T > operation)
    {
        EntityManagerFactory entityManagerFactory = PersistenceManager.getInstance().getEntityManagerFactory(username, password);

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        T result = operation.apply(entityManager);

        entityManager.close();

        return result;
    }

    public static void flush()
    {
        EntityManagerFactory entityManagerFactory = PersistenceManager.getInstance().getEntityManagerFactory(username, password);

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.flush();
    }
}