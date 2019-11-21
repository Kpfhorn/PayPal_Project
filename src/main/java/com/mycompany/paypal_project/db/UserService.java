package com.mycompany.paypal_project.db;

import java.util.Random;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserService {
    
    @PersistenceContext
    private EntityManager em;
    
    public User selectByID(String id){
        return em.find(User.class, id);
    }
    
    public String addUser(User u){
        em.persist(u);
        return u.getUserID();
    }
    
    public String removeUser(int id){
        User u = em.find(User.class, id);
        em.remove(u);
        return u.getUserID();
    }
    
}
