package br.com.neostore;

import org.glassfish.jersey.internal.inject.AbstractBinder;

public class ApplicationBinder extends AbstractBinder{
    @Override
    protected void configure(){
        bind(FornecedorDAO.class).to(FornecedorDAO.class);
    }
}
