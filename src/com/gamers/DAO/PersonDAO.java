package com.gamers.DAO;

import com.gamers.Entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PersonDAO extends DAOService<Person, Long>{

    public PersonDAO(){
        super(Person.class);
    }

    public Person findByNickname(String nickname)
    {

        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createNativeQuery("SELECT * FROM ЛИЧНОСТЬ WHERE НИКНЕЙМ = '" + nickname + "';", Person.class);

        Person person = (Person) query.getSingleResult();

        entityManager.getTransaction().commit();
        entityManager.close();

        return person;
    }

    public Person findByEmail(String email)
    {

        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createNativeQuery("SELECT * FROM ЛИЧНОСТЬ WHERE ЭЛ_ПОЧТА = '" + email + "';", Person.class);

        Person person = (Person) query.getSingleResult();

        entityManager.getTransaction().commit();
        entityManager.close();

        return person;
    }

    public Person findByNicknameAndPassword(String nickname, String password)
    {

        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createNativeQuery("SELECT * FROM ЛИЧНОСТЬ WHERE НИКНЕЙМ = '" + nickname + "' AND ХЕШ_ПАРОЛЬ = '" + password + "';", Person.class);

        Person person = (Person) query.getSingleResult();

        entityManager.getTransaction().commit();
        entityManager.close();

        return person;
    }

    public List<Person> findByGroupName(String groupname)
    {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createNativeQuery(
                "SELECT НИКНЕЙМ, ИД_ЛИЧНОСТЬ, ЭЛ_ПОЧТА, ХЕШ_ПАРОЛЬ " +
                "FROM ЛИЧНОСТЬ " +
                "INNER JOIN ГРУППА_ЛИЧН USING (НИКНЕЙМ) " +
                "WHERE ГРУППА_ЛИЧН.ГРУППА = '" + groupname + "';", Person.class);

        List<Person> persons = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();


        return persons;
    }


}
