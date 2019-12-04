/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.paypal_project.db;

import java.util.Collection;
import java.util.Random;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author kpfho
 */
@Stateless
public class ActivitiesService {
    
    @PersistenceContext
    private EntityManager em;
    
    public Activities selectByID(int id){
        return em.find(Activities.class, id);
    }
    
    public int addActivities(Activities r){
        em.persist(r);
        return r.getActivityID();
    }
    
    public int removeActivities(int id){
        Activities r = em.find(Activities.class, id);
        em.remove(r);
        return r.getActivityID();
    }

    public int getNewID(){
        int id = new Random().nextInt(100000);
        Activities exists = em.find(Activities.class, id);
        if(exists != null){
            return getNewID();
        }else{
            return id;
        }
    }
    
}
