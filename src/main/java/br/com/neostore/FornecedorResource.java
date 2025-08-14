package br.com.neostore;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/fornecedores")
public class FornecedorResource {

    @Inject
    private FornecedorDAO fornecedorDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarFornecedores() {
        List<Fornecedor> fornecedores = fornecedorDAO.listarTodos();
        return Response.ok(fornecedores).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarFornecedor(Fornecedor fornecedor) {
        Fornecedor fornecedorSalvo = fornecedorDAO.salvar(fornecedor);
        return Response.ok(fornecedorSalvo).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)

    public Response buscarFornecedor(@PathParam("id") Long id){
        Fornecedor fornecedor = fornecedorDAO.buscarPorId(id);

        if (fornecedor == null){
            return Response.ok(fornecedor).build();
        }else {
            return Response.ok(fornecedor).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarFornecedor(@PathParam("id") Long id, Fornecedor fornecedor){
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
}
