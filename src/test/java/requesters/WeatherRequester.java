package requesters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Response;
import org.springframework.web.client.RestTemplate;

//Step 1

public class WeatherRequester {
    private final String PREFIX = "https://samples.openweathermap.org/data/2.5/weather?q=";
    private final String POSTFIX = "&appid=439d4b804bc8187953eb36d2a8c26a02";

    public Response requestWeather(String city, String country) throws JsonProcessingException {
        String url = PREFIX + city + "," + country + POSTFIX;

        // Step 2 + 3

        RestTemplate restTemplate = new RestTemplate();
        // return restTemplate.getForEntity(url, Response.class).getBody(); - Response.class does not work
        String responseToParse = restTemplate.getForEntity(url, String.class).getBody();

        //Step 4

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseToParse, Response.class);

    }

}
