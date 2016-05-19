package server;

import com.sun.net.httpserver.HttpServer;
import handlers.StaticFileHandler;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Scanner;

/**
 *
 * @author Simon
 */
public class CarbonServer {

    private HttpServer server;
    private String rootPath;
    
    
    public static void main(String[] args) throws IOException {
        
        CarbonServer s = new CarbonServer();
        
        s.start();
        
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        s.stop();
        
    }
    
    
    public CarbonServer() throws IOException {
        server = HttpServer.create(new InetSocketAddress("127.0.0.1", 3000), 0);
        server.createContext("/public", new StaticFileHandler("testfiles/"));
        server.setExecutor(null);
    }

    public void start() {
        server.start();
    }

    public void stop() {
        server.stop(1);
    }

}
