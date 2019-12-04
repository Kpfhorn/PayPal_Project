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
public class DownloadsService {
    @PersistenceContext
    private EntityManager em;
    
    public Downloads selectByID(DownloadsPK id){
        return em.find(Downloads.class, id);
    }
    
    public DownloadsPK addDownload(Downloads d){
        em.persist(d);
        return d.getDownloadsPK();
    }
    
    public Downloads removeDownload(Downloads d){
        em.remove(d);
        return d;
    }
    
}
