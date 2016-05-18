package server;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import handlers.StaticFileHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 *
 * @author Simon
 */
public class CarbonServer {

    HttpServer server;

    public CarbonServer() throws IOException {
        server = HttpServer.create(new InetSocketAddress("127.0.0.1", 3000), 0);
        server.createContext("/public", new StaticFileHandler());
        server.setExecutor(null);
    }

    public void start() {
        server.start();
    }

    public void stop() {
        server.stop(1);
    }

}
