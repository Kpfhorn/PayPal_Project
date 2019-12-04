/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.paypal_project.resources.service;

import com.mycompany.paypal_project.db.Activities;
import com.mycompany.paypal_project.db.Measures;
import com.mycompany.paypal_project.db.Profilecategorygoaloutcomes;
import com.mycompany.paypal_project.db.Profilecategorygoals;
import com.mycompany.paypal_project.db.Roadmapactivities;
import com.mycompany.paypal_project.db.Roadmaps;
import java.util.ArrayList;
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
@Path("pcg")
public class ProfilecategorygoalsFacadeREST extends AbstractFacade<Profilecategorygoals> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    public ProfilecategorygoalsFacadeREST() {
        super(Profilecategorygoals.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Profilecategorygoals entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Profilecategorygoals entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Profilecategorygoals find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("{id}/activities")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Activities> findActivities(@PathParam("id") Integer id) {
        TypedQuery<Roadmaps> q = em.createNamedQuery("Roadmaps.findByProfileCategoryGoalID",Roadmaps.class);
        q.setParameter("profileCategoryGoalID", em.find(Profilecategorygoals.class, id));
        Roadmaps r = q.getSingleResult();
        TypedQuery<Roadmapactivities> q2 = em.createNamedQuery("Roadmapactivities.findByRoadMapID", Roadmapactivities.class);
        q2.setParameter("roadMapID", r.getRoadMapID());
        List<Roadmapactivities> raclist = q2.getResultList();
        System.out.println(q2.getResultList().size());
        List<Activities> out = new ArrayList<>();
        for(Roadmapactivities rac: raclist){
            TypedQuery<Activities> q3 = em.createNamedQuery("Activities.findByActivityID", Activities.class);
            q3.setParameter("activityID", rac.getRoadmapactivitiesPK().getActivityID());
            out.add(q3.getSingleResult());
        }
        return out;
        
    }
    
    @GET
    @Path("{id}/outcome")
    @Produces(MediaType.APPLICATION_JSON)
    public Measures findOutcome(@PathParam("id") Integer id){
        TypedQuery<Profilecategorygoaloutcomes> q = em.createNamedQuery("Profilecategorygoaloutcomes.findByProfileCategoryGoalID", Profilecategorygoaloutcomes.class);
        q.setParameter("profileCategoryGoalID",  id);
        Profilecategorygoaloutcomes pcgo = q.getSingleResult();
        TypedQuery<Measures> q2 = em.createNamedQuery("Measures.findByMeasureID", Measures.class);
        q2.setParameter("measureID", pcgo.getProfilecategorygoaloutcomesPK().getMeasureID());
        return q2.getSingleResult();
    }
    
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Profilecategorygoals> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Profilecategorygoals> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
