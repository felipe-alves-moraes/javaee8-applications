package br.com.fmoraes.environmentawareconfiguration.resources;

import br.com.fmoraes.environmentawareconfiguration.model.Person;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author fmoraes
 */
@Path("persons")
@Stateless
public class PersonResource {

    @PersistenceContext
    private EntityManager em;
    
    @POST
    public void create(JsonObject json) {
        em.persist(new Person(json.getString("name")));
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAll() {
        return em.createNamedQuery("Person.findAll").getResultList();
    }
     
    
}