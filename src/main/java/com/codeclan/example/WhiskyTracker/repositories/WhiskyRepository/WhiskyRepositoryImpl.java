package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    /*
    Todo: get all the whiskies from a particular distillery of a particular age
    has: name of distillery - String name, age of whisky - int age
    wants: list of whiskies List<Whisky>
     */

    @Transactional
    public List<Whisky> getAllWhiskiesFromGivenDistilleryOfGivenAge(String name, int age){
        List<Whisky> results = null;
        //set up session connecting to db with entity manager
        Session session = entityManager.unwrap(Session.class);

        //protect if something goes wrong
        try {
            //create criteria from session on our whisky class
            Criteria cr = session.createCriteria(Whisky.class);
            //create alias to distillery
            cr.createAlias("distillery", "distilleryAlias");
            //add restriction to our criteria
            cr.add(Restrictions.eq("distilleryAlias.name", name));
            cr.add(Restrictions.eq("age", age));

            results = cr.list();

        } catch(HibernateException ex){
            ex.printStackTrace();
        }
        return results;
    }
}
