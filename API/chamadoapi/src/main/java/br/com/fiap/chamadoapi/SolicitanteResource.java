package br.com.fiap.chamadoapi;

import br.com.fiap.chamadoapi.model.Solicitante;
import br.com.fiap.chamadoapi.service.SolicitanteService;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("solicitante")
public class SolicitanteResource {

	private SolicitanteService service = new SolicitanteService();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(Solicitante solicitante) {
    	if (service.save(solicitante)) {
    		return Response.ok(solicitante).build();
    	}else {
            return Response.status(Response.Status.BAD_REQUEST).build();

    	} 
    }
}
