package br.com.fiap.chamadoapi;

import br.com.fiap.chamadoapi.model.Chamado;
import br.com.fiap.chamadoapi.service.ChamadoService;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("chamado")
public class ChamadoResource {
	
	private ChamadoService service = new ChamadoService();
	

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(Chamado chamado) {
        if (service.save(chamado)) {
            return Response.ok(chamado).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
   
}