package br.com.fiap.chamadoapi;

import br.com.fiap.chamadoapi.model.Veiculo;
import br.com.fiap.chamadoapi.service.VeiculoService;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("veiculo")
public class VeiculoResource {
	
    private VeiculoService service = new VeiculoService();


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response insert(Veiculo veiculo) {
		if (service.save(veiculo)) {
			return Response.ok(veiculo).build();
		}else {
			return Response.status(Response.Status.BAD_REQUEST).build();

		}
		
	}
}
