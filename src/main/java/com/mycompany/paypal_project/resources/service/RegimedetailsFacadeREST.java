/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.paypal_project.resources.service;

import com.mycompany.paypal_project.db.Regimedetails;
import com.mycompany.paypal_project.db.RegimedetailsPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author kpfho
 */
@Stateless
@Path("regimedetails")
public class RegimedetailsFacadeREST extends AbstractFacade<Regimedetails> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    private RegimedetailsPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;regimeID=regimeIDValue;regimeInfoFieldID=regimeInfoFieldIDValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.mycompany.paypal_project.db.RegimedetailsPK key = new com.mycompany.paypal_project.db.RegimedetailsPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> regimeID = map.get("regimeID");
        if (regimeID != null && !regimeID.isEmpty()) {
            key.setRegimeID(new java.lang.Integer(regimeID.get(0)));
        }
        java.util.List<String> regimeInfoFieldID = map.get("regimeInfoFieldID");
        if (regimeInfoFieldID != null && !regimeInfoFieldID.isEmpty()) {
            key.setRegimeInfoFieldID(new java.lang.Integer(regimeInfoFieldID.get(0)));
        }
        return key;
    }

    public RegimedetailsFacadeREST() {
        super(Regimedetails.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Regimedetails entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Regimedetails entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.mycompany.paypal_project.db.RegimedetailsPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Regimedetails find(@PathParam("id") PathSegment id) {
        com.mycompany.paypal_project.db.RegimedetailsPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Regimedetails> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Regimedetails> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
