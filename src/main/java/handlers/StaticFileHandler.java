package handlers;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author Simon
 */
public class StaticFileHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange he) throws IOException {

        String url = he.getRequestURI().getPath();

        String s = "sd";

        Headers h = he.getResponseHeaders();

        h.add("Content-Type", "text/plain");
        h.add("charset", "utf-8");
        he.sendResponseHeaders(200, 0);
        try (OutputStream responseBody = he.getResponseBody()) {
            responseBody.write(s.getBytes(), 0, s.getBytes().length);
        }

    }

}
