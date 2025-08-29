import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherData {

    private static String apiKey = Config.getKey();

    public static void main(String[] args) {
        HttpResponse<String> testResponse = getWeather("London", "metric");
        System.out.println(testResponse.body());
    }

    //TODO: overload method for entry for postcode, coordinates
    public static HttpResponse<String> getWeather(String city, String units) {

        try {
            String requestURL = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey +
                    "&units=" + units;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(requestURL)).GET().build();

            HttpResponse<String> weatherResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

            return weatherResponse;

        } catch (IOException e){
            System.out.println("IOException");
        } catch (InterruptedException e ) {
            System.out.println("Interrupted Exception");
        }

        return null;
    }


}
