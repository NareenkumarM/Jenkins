import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Main {
    private static final String VERSION = "1.0";

    public static void main(String[] args) throws IOException {
        String hostname;
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            hostname = "Unknown";
        }

        HttpServer server = HttpServer.create(new InetSocketAddress(80), 0);
        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String response = "<h1>It works!</h1>\n<h1>Hostname: " + hostname + "</h1>\n<h1>Version: " + VERSION + "</h1>";
                exchange.sendResponseHeaders(200, response.length());
                exchange.getResponseBody().write(response.getBytes());
                exchange.getResponseBody().close();
            }
        });
        server.setExecutor(null);
        server.start();
    }
}
