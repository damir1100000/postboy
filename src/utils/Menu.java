package utils;

import http.Format;
import http.Response;
import http.request.Operation;
import http.request.Request;

import java.util.Scanner;

public class Menu  {
    public static final String GREEN_BRIGHT = "\033[0;92m";
    private final Scanner scanner = new Scanner(System.in);
    private String endpoint;
    private Convertor convertor;
    public void start () {
            System.out.println(GREEN_BRIGHT + "Please enter the URL");
            String URL = scanner.nextLine();
            //TODO: rethink this part
            this.setEndpoint(URL);
            System.out.println("Please choose the action: ");
            System.out.println("1. Get");
            System.out.println("2. Post");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            int option = Integer.parseInt(scanner.nextLine());
            this.operate(option);
            scanner.close();
    }

    public String operate (int option) {
        switch (option) {
            case 1: {
                System.out.println("Please choose the response body format");
                System.out.println("1. JSON");
                System.out.println("2. JSON");
                System.out.println("3. JSON");
                this.read();
                break;
            }
            case 2: {
                this.post();
                break;
            }
            case 3: {
                this.put();
                break;
            }
            case 4: {
                this.delete();
                break;
            }
        }
        return "Operation done";
    }

    public void setEndpoint (String URL) {
        this.endpoint = URL;
    }

    public void read () {
        Request request = new Request(this.endpoint, Operation.GET);
        Response response = request.getResponse();
        this.convertor = new Convertor(response.getContent(), Format.JSON, Format.JSON);
        System.out.println(this.convertor.toJson());
        System.out.println("Done!");
    };

    public Response post () {
        Request request = new Request(this.endpoint, Operation.POST);
        return null;
    };

    public Response put () {
        Request request = new Request(this.endpoint, Operation.PUT);
        return null;
    };

    public Response delete () {
        Request request = new Request(this.endpoint, Operation.DELETE);
        return null;
    };
}
