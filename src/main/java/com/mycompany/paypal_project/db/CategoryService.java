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
public class CategoryService {
    @PersistenceContext
    private EntityManager em;
    
    public Categories selectByID(int id){
        return em.find(Categories.class, id);
    }
    
    public int addCategory(Categories c){
        em.persist(c);
        return c.getCategoryID();
    }
    
    public int removeCategory(int id){
        Categories c = em.find(Categories.class, id);
        em.remove(c);
        return c.getCategoryID();
    }
    
}
