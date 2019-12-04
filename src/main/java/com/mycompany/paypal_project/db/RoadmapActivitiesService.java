/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.paypal_project.db;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kpfho
 */
@Stateless
public class RoadmapActivitiesService {
    @PersistenceContext
    private EntityManager em;
    
    public void addActivity(Roadmapactivities ra){
        em.persist(ra);
    }
    
}
