import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class MainTest {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Main.main(args);
            }
        });
        thread.start();

        try {
            URL url = new URL("http:");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                Scanner scanner = new Scanner(inputStream);
                StringBuilder response = new StringBuilder();
                while (scanner.hasNextLine()) {
                    response.append(scanner.nextLine());
                }
                scanner.close();
                inputStream.close();
                connection.disconnect();

                String hostname = java.net.InetAddress.getLocalHost().getHostName();
                String want = String.format("<h1>It works!</h1>\n<h1>Hostname: %s</h1>\n<h1>Version: %s</h1>", hostname, version);
                String got = response.toString();
                if (!got.equals(want)) {
                    throw new AssertionError(String.format("Got wrong response: got %s want %s", got, want));
                }
            } else {
                throw new IOException("HTTP request failed with response code: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
