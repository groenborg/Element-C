package server;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
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
        server.createContext("/", (HttpExchange he) -> {
            byte[] hello = "hello".getBytes();
            Headers h = he.getResponseHeaders();
            he.sendResponseHeaders(200, 0);
            h.add("Content-Type", "text/html");
            h.add("charset", "utf-8");
            
            try (OutputStream responseBody = he.getResponseBody()) {
                responseBody.write(hello, 0, hello.length);
            }
        });
        server.setExecutor(null);
    }

    public void start() {
        server.start();
    }

    public void stop() {
        server.stop(1);
    }

}
