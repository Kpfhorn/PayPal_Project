/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.paypal_project.resources.service;

import com.mycompany.paypal_project.db.Profilecategories;
import com.mycompany.paypal_project.db.Profiles;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author kpfho
 */
@Stateless
@Path("profiles")
public class ProfilesFacadeREST extends AbstractFacade<Profiles> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    public ProfilesFacadeREST() {
        super(Profiles.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Profiles entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Profiles entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Profiles find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Profiles> findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("/dump")
    @Produces(MediaType.APPLICATION_JSON)
    public List dump(){
        return em.createNativeQuery("SCRIPT TO './test/test.sql'").getResultList();
    }
    
    @GET
    @Path("{id}/profilecategories")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Profilecategories> findProfileCategories(@PathParam("id") Integer id){
        TypedQuery<Profilecategories> q = em.createNamedQuery("Profilecategories.findByProfileID", Profilecategories.class);
        q.setParameter("profileID", em.find(Profiles.class, id));
        return q.getResultList();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Profiles> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
