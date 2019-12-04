/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.paypal_project.db;

import java.util.Random;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kpfho
 */

@Stateless
public class RoadmapsService {
    @PersistenceContext
    private EntityManager em;
    
    public Roadmaps selectByID(int id){
        return em.find(Roadmaps.class, id);
    }
    
    public int addRoadmap(Roadmaps r){
        em.persist(r);
        return r.getRoadMapID();
    }
    
    public int removeRoadmap(int id){
        Roadmaps r = em.find(Roadmaps.class, id);
        em.remove(r);
        return r.getRoadMapID();
    }
    
     public int getNewID(){
        int id = new Random().nextInt(100000);
        Roadmaps exists = em.find(Roadmaps.class, id);
        if(exists != null){
            return getNewID();
        }else{
            return id;
        }
    }
    
}
