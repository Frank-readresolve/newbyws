package fr.formation.newbyws;

import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("facturation")
@Produces(MediaType.APPLICATION_JSON)
public class FacturationRessource {

    @GET
    @Path("/facture/{id}")
    public Facture retrieveOne(@PathParam("id") Long id) {
	Facture facture = new Facture("test", 0.0);
	facture.setId(id);
	return facture;
    }

    @GET
    @Path("/factures")
    public List<Facture> retrieveAll() {
	List<Facture> factures = new ArrayList<>();
	Facture facture = null;
	for (int i = 0, index = 1; i < 10; i++, index++) {
	    facture = new Facture("INV" + index, 1000.50 * index);
	    facture.setId(Long.valueOf(index));
	    factures.add(facture);
	}
	return factures;
    }

    @PUT
    @Path("/facture/creer")
    public Response create(@QueryParam("numero") String numero,
	    @QueryParam("montant") Double montant) {
	Facture facture = new Facture(numero, montant);
	facture.setId(Long.valueOf(1));
	return Response.ok(facture).build();
    }

    @POST
    @Path("/facture/modifier/montant/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response updateById(@PathParam("id") Long id,
	    @FormParam("montant") Double montant) {
	Facture facture = getById(id);
	facture.setMontant(montant);
	return Response.ok(facture).build();
    }

    @POST
    @Path("/facture/modifier")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Facture facture) {
	System.out.println("Facture modifiee: " + facture);
	return Response.ok().build();
    }

    @DELETE
    @Path("/facture/supprimer/{id}")
    public Response delete(@PathParam("id") Long id) {
	deletefacture(id);
	return Response.ok().build();
    }

    private static Facture getById(Long id) {
	Facture facture = new Facture("20180101/256", null);
	facture.setId(id);
	return facture;
    }

    private static void deletefacture(Long id) {
	System.out.println("Facture " + id + " supprimee!");
    }
}
