package br.com.neostore.resource;

import br.com.neostore.dao.FornecedorDAO;
import br.com.neostore.entity.Fornecedor;
import br.com.neostore.util.Validador;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/fornecedores")
public class FornecedorResource {

    @Inject
    private FornecedorDAO fornecedorDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarFornecedores(

            //captura o valor do parametro de consulta "query parameter" da url.
            @QueryParam("page") @DefaultValue("1") int page,

            //
            @QueryParam("size") @DefaultValue("5") int size
    ) {
        List<Fornecedor> fornecedores = fornecedorDAO.listarPaginas(page, size);

        return Response.ok(fornecedores).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarFornecedor(Fornecedor fornecedor) {

        Response erroResponse = validarFornecedor(fornecedor);
        if (erroResponse != null) {
            return erroResponse;
        }

        Fornecedor fornecedorSalvo = fornecedorDAO.salvar(fornecedor);
        return Response.ok(fornecedorSalvo).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)

    public Response buscarFornecedor(@PathParam("id") Long id){
        Fornecedor fornecedor = fornecedorDAO.buscarPorId(id);

        if (fornecedor == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }else {
            return Response.ok(fornecedor).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarFornecedor(@PathParam("id") Long id, Fornecedor fornecedor){

        Response erroResponse = validarFornecedor(fornecedor);
        if (erroResponse != null) {
            return erroResponse;
        }

        fornecedor.setId(id);

        Fornecedor fornecedorAtualizado = fornecedorDAO.atualizar(fornecedor);
        return Response.ok(fornecedorAtualizado).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletarFornecedor(@PathParam("id") Long id){
        fornecedorDAO.deletar(id);

        return Response.ok().build();
    }

    private Response validarFornecedor(Fornecedor fornecedor) {
        if (!Validador.validaCNPJ(fornecedor.getCnpj())) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("O CNPJ fornecido é inválido.")
                    .build();
        }

        if (!Validador.validaEmail(fornecedor.getEmail())) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("O formato do e-mail é inválido.")
                    .build();
        }
        // se todas as validações passaram, retorna null
        return null;
    }


    //endpoint para importar a lista de fornecedores de uma vez
    @POST
    @Path("/importar")
    @Consumes(MediaType.APPLICATION_JSON)


    public Response importar(List<Fornecedor> fornecedores){
        for (Fornecedor fornecedor : fornecedores){

            Response erroResponse = validarFornecedor(fornecedor);

            if (erroResponse != null) {
                return erroResponse;
            }
        }

        fornecedorDAO.salvarTodos(fornecedores);

        return Response.ok().build();
    }
}
