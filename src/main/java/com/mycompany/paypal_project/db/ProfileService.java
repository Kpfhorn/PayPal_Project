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
public class ProfileService {
    
    @PersistenceContext
    private EntityManager em;
    
    public Profiles selectByID(int id){
        return em.find(Profiles.class, id);
    }
    
    public int addProfile(Profiles p){
        em.persist(p);
        return p.getProfileID();
    }
    
    public int removeProfile(int id){
        Profiles p = em.find(Profiles.class, id);
        em.remove(p);
        return p.getProfileID();
    }
    
    public int getNewID(){
        int id = new Random().nextInt(100000);
        if(em.find(Profiles.class, id) != null){
            return getNewID();
        }else{
            return id;
        }
    }
}
