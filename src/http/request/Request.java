package http.request;

import http.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request {
    private URL url;
    private Operation operation;
    private Header header;
    public Request(String URL, Operation operation) {
        try {
            this.url = new URL(URL);
            this.operation = operation;
        } catch (IOException ioException) {
            ioException.getCause();
        } finally {
            System.out.println("The request has been initialized.");
        }
    }
    private HttpURLConnection establishConnection () throws IOException {
        System.out.println("Establishing connection..");
        HttpURLConnection connection = (HttpURLConnection) this.url.openConnection();
        connection.setRequestMethod(operation.toString());
        return connection;
    }

    public Response getResponse () {
        Response response = null;
        try {
            StringBuilder builder = new StringBuilder();
            InputStreamReader inputStreamReader = new InputStreamReader(this.establishConnection().getInputStream());
            BufferedReader reader = new BufferedReader(inputStreamReader);
            System.out.println("Fetching data..");
            String line;

            while((line = reader.readLine()) != null) {
                builder.append(line);
            }

            response = new Response(builder.toString());
            reader.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return response;
    }
}
