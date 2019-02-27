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

    @Transactional
    public List<Whisky> getAllWhiskiesFromGivenDistilleryOfGivenAge(Long id, int age){
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
            cr.add(Restrictions.eq("distilleryAlias.id", id));
            cr.add(Restrictions.eq("age", age));

            results = cr.list();

        } catch(HibernateException ex){
            ex.printStackTrace();
        }
        return results;
    }

    @Transactional
    public List<Whisky> getAllWhiskiesbyRegion(String region){
        List<Whisky> results = null;

        Session session = entityManager.unwrap(Session.class);

        try{
            Criteria cr = session.createCriteria(Whisky.class);

            cr.createAlias("distillery", "distilleryAlias");
            cr.add(Restrictions.eq("distilleryAlias.region", region));
            results = cr.list();
        } catch(HibernateException ex){
            ex.printStackTrace();
        }
        return results;
    }
}
