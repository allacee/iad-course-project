package com.gamers.DAO;

import com.gamers.Entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

public class PersonDAO extends DAOService<Person, Long>{

    public PersonDAO(){
        super(Person.class);
    }

    public Person findByNickname(String nickname) throws EntityNotFoundException {

        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createNativeQuery("SELECT * FROM ЛИЧНОСТЬ WHERE НИКНЕЙМ = '" + nickname + "';", Person.class);

        Person person = (Person) query.getSingleResult();

        entityManager.getTransaction().commit();
        entityManager.close();

        if (person == null)
            throw new EntityNotFoundException("No user with such nickname");

        return person;
    }

    public Person findByEmail(String email) throws  EntityNotFoundException{

        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createNativeQuery("SELECT * FROM ЛИЧНОСТЬ WHERE ЭЛ_ПОЧТА = '" + email + "';", Person.class);

        Person person = (Person) query.getSingleResult();

        entityManager.getTransaction().commit();
        entityManager.close();

        if (person == null)
            throw new EntityNotFoundException("No user with such email");

        return person;
    }

    public Person findByNicknameAndPassword(String nickname, String password) throws EntityNotFoundException{

        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createNativeQuery("SELECT * FROM ЛИЧНОСТЬ WHERE НИКНЕЙМ = '" + nickname + "' AND ХЕШ_ПАРОЛЬ = '" + password + "';", Person.class);

        Person person = (Person) query.getSingleResult();

        entityManager.getTransaction().commit();
        entityManager.close();

        if (person == null)
            throw new EntityNotFoundException("Bad login or password");

        return person;
    }


}
