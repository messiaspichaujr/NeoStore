package br.com.neostore.config;

import org.glassfish.jersey.server.ResourceConfig;

public class MyApplication extends ResourceConfig {

    public MyApplication() {
        packages("br.com.neostore");
        register(new ApplicationBinder());
    }
}