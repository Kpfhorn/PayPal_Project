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

@Stateless
public class RegimeService {
    @PersistenceContext
    private EntityManager em;
    
    public Regime selectByID(int id){
        return em.find(Regime.class, id);
    }
    
    public int addRegime(Regime r){
        em.persist(r);
        return r.getRegimeID();
    }
    
    public int removeRegime(int id){
        Regime r = em.find(Regime.class, id);
        em.remove(r);
        return r.getRegimeID();
    }
    
    public Collection<Regime> getPublished(){
        TypedQuery<Regime> q = em.createNamedQuery("Regime.findByPublishStatus", Regime.class);
        q.setParameter("publishStatus", true);
        return q.getResultList();
    }
    
    public int getNewID(){
        int id = new Random().nextInt(100000);
        Regime exists = em.find(Regime.class, id);
        if(exists != null){
            return getNewID();
        }else{
            return id;
        }
    }
    
    
    
}
