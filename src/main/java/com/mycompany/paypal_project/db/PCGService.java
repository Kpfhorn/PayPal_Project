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
public class PCGService {
    
    @PersistenceContext
    private EntityManager em;
    
    public Profilecategorygoals selectByID(int id){
        return em.find(Profilecategorygoals.class, id);
    }
    
    public Profilecategorygoals addPCG(Profilecategorygoals pcg){
        em.persist(pcg);
        return pcg;
    }
    
    public Profilecategorygoals removePCG(int id){
        Profilecategorygoals pcg = em.find(Profilecategorygoals.class, id);
        em.remove(pcg);
        return pcg;
    }
    
    public int getNewID(){
        int id = new Random().nextInt(100000);
        Profilecategorygoals exists = em.find(Profilecategorygoals.class, id);
        if(exists != null){
            return getNewID();
        }else{
            return id;
        }
    }
}
