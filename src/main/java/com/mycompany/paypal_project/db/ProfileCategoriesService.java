/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.paypal_project.db;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author kpfho
 */
@Stateless
public class ProfileCategoriesService {
    
    @PersistenceContext
    private EntityManager em;
    
    public Profilecategories selectByID(int id){
        return em.find(Profilecategories.class, id);
    }
    
    public int addProfileCategory(Profilecategories pc){
        em.persist(pc);
        return pc.getProfileCategoryID();
    }
    
    public int removeProfileCategory(int id){
        Profilecategories pc = em.find(Profilecategories.class, id);
        em.remove(pc);
        return pc.getProfileCategoryID();
    }
    
    public Collection<Profilecategories> getByProfile(int pid){
        TypedQuery<Profilecategories> q = em.createNamedQuery("Profilecategories.findByProfileID", Profilecategories.class);
        q.setParameter("profileID", pid);
        return q.getResultList();
    }
    
}
