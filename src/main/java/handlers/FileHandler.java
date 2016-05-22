package handlers;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author Simon
 */
public class FileHandler implements HttpHandler {

    private ResponseBuilder response;
    private String rootPath = "";

    public FileHandler(String rootPath) {
        this.rootPath = rootPath;
    }

    @Override
    public void handle(HttpExchange he) throws IOException {

        //removes the handler absolute path
        String url = he.getRequestURI().getPath();
        

        response = new ResponseBuilder();
        File file = response.getFile(rootPath + url);

        if (file == null) {
            response.send(he, ResponseBuilder.HTTP_NOT_FOUND, ResponseBuilder.FILE_NOT_FOUND.getBytes());
        } else {

            byte[] bytesToSend = new byte[(int) file.length()];
            try (FileInputStream input = new FileInputStream(file);) {
                input.read(bytesToSend, 0, bytesToSend.length);
            }

            Headers h = he.getResponseHeaders();
            h.add("Content-Type", response.getMimeType(url));
            h.add("charset", "utf-8");
            response.send(he, ResponseBuilder.HTTP_OK, bytesToSend);
        }
    }

}
