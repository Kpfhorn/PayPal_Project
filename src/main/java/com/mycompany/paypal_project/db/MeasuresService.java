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
public class MeasuresService {
    @PersistenceContext
    private EntityManager em;
    
    public int addMeasure(Measures m){
        em.persist(m);
        return m.getMeasureID();
    }
    
    public int removeMeasure(int id){
        Measures m = em.find(Measures.class, id);
        em.remove(m);
        return m.getMeasureID();
    }
    
    public int getNewID(){
        int id = new Random().nextInt(100000);
        Measures exists = em.find(Measures.class, id);
        if(exists != null){
            return getNewID();
        }else{
            return id;
        }
    }
}
