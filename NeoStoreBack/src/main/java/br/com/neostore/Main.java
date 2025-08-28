package br.com.neostore;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class Main {
    public static void main(String[] args) {

        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        ServletContainer servletContainer = new ServletContainer(new br.com.neostore.MyApplication());
        ServletHolder servletHolder = new ServletHolder(servletContainer);

        context.addServlet(servletHolder, "/api/*");

        System.out.println("Servidor iniciado em http://localhost:8080");

        try {
            server.start();
            server.join();

        } catch (Exception e) {
            System.out.println("Erro ao iniciar o servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}