import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherData {

    private static String apiKey = Config.getKey();

    public static void main(String[] args) {
        HttpResponse<String> testResponse = getWeatherByCity("London", "metric");
        System.out.println(testResponse.body());

        HttpResponse<String> testResponse2 = getWeatherByCoordinates("40.19",  "54.02", "metric");
        System.out.println(testResponse2.body());

        HttpResponse<String> testResponse3 = getWeatherByPostcode("NR4", "GB", "metric");
        System.out.println(testResponse3.body());

    }

    public static HttpResponse<String> getWeatherByCity(String city, String units) {
        /* Create an API request based off a city input, return the data */

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


    public static HttpResponse<String> getWeatherByCoordinates(String latitude, String longitude, String units) {
        /* Create an API request based off a latitude and longitude input, return the data */

        try {
            String requestURL = "https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude
                    + "&appid=" + apiKey + "&units=" + units;

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

    public static HttpResponse<String> getWeatherByPostcode(String postcode, String countryCode, String units) {
        /* Create an API request based off a postcode input, return the data */

        try {
            String requestURL = "https://api.openweathermap.org/data/2.5/weather?zip=" + postcode + "," + countryCode
                    + "&appid=" + apiKey + "&units=" + units;

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
