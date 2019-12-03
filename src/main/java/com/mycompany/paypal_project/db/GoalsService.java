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
public class GoalsService {
    
    @PersistenceContext
    private EntityManager em;
    
    public Goals selectByID(int id){
        return em.find(Goals.class, id);
    }
    
    public int addGoal(Goals g){
        em.persist(g);
        return g.getGoalID();
    }
    
    public int removeGoal(int id){
        Goals g = em.find(Goals.class, id);
        em.remove(g);
        return g.getGoalID();
    }
    
    public int getNewID(){
        int id = new Random().nextInt(100000);
        Goals exists = em.find(Goals.class, id);
        if(exists != null){
            return getNewID();
        }else{
            return id;
        }
    }
}
