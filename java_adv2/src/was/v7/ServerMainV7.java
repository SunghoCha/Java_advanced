package was.v7;

import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;
import was.httpserver.HttpServer;
import was.httpserver.ServletManager;
import was.httpserver.servlet.annotation.AnnotationServletV1;
import was.httpserver.servlet.annotation.Mapping;
import was.v5.servlet.DiscardServlet;

import java.io.IOException;
import java.util.List;

public class ServerMainV7 {

    public static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        List<Object> controllers = List.of(new SiteControllerV7(), new SearchControllerV7());
        AnnotationServletV1 servlet = new AnnotationServletV1(controllers);

        ServletManager servletManager = new ServletManager();
        servletManager.setDefaultServlet(servlet);
        servletManager.add("/favicon.co", new DiscardServlet());
        HttpServer server = new HttpServer(PORT, servletManager);
        server.start();
    }
}
