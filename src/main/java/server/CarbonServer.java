package server;

import com.sun.net.httpserver.HttpServer;
import handlers.FileHandler;
import java.io.IOException;
import java.net.InetSocketAddress;

/**
 *
 * @author Simon
 */
public class CarbonServer implements IServer {

    private HttpServer server;
    private String rootPath;
    private String address;
    private int port;

    public CarbonServer(String rootPath, String address, int port) throws IOException {
        this.rootPath = rootPath;
        this.address = address;
        this.port = port;

        server = HttpServer.create(new InetSocketAddress(this.address, this.port), 0);
        server.createContext("/", new FileHandler(this.rootPath));
        server.setExecutor(null);
    }

    @Override
    public void start() {
        server.start();
    }

    @Override
    public void stop() {
        server.stop(1);
    }

}
