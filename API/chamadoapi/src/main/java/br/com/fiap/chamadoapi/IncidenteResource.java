package br.com.fiap.chamadoapi;

import br.com.fiap.chamadoapi.model.Incidente;
import br.com.fiap.chamadoapi.service.IncidenteService;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("incidente")
public class IncidenteResource {
	
    private IncidenteService service = new IncidenteService();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(Incidente incidente) {
    	if (service.save(incidente)) {
			return Response.ok(incidente).build();
    	} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
        
    }
   

}
