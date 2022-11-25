import java.io.*;
import java.net.URI;
import java.util.*;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    ArrayList<String> words = new ArrayList<String>();

    public String handleRequest(URI url) {
        if (url.getPath().contains("/add")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                words.add(parameters[1]);
                return String.format("Added to the list: %s", parameters[1]);
            }
        }

        else if (url.getPath().contains("/search")) {
            String[] parameter = url.getQuery().split("=");
            if (parameter[0].equals("s")) {
                String input = parameter[1];
                String results = "";
                for (int i = 0 ; i < words.size(); i++) {
                    if (words.get(i).contains(input)) {
                        results = results + words.get(i) + " ";
                    }
                }

                if (results == ""){
                    return String.format("Nothing Found!");
                }
                else {
                    return String.format("Search results: %s", results);
                }
            }
        
        }
        return "404 Not Found!";
    }
}


public class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
