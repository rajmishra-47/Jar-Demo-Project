package com.Jar_Demo_Project.Jar_Demo_Project.Services;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

@Service
public class ConverterService {
    public   double Convert(String to, String from , double amount) {


        String url = "https://v6.exchangerate-api.com/v6/2294ffd87900dadad02a0c94/latest/"+from;

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        Map<String, Object> jsonResponse = new HashMap<>();
        Map<String, String> result = new HashMap<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // Convert the JSON string to a Map
            jsonResponse = objectMapper.readValue(response, Map.class);

            // Extracting the conversion rates
            Map<String, Object> conversionRates = (Map<String, Object>) jsonResponse.get("conversion_rates");

            // If you specifically want the USD value, you can set it like this:
            for (Map.Entry<String, Object> entry : conversionRates.entrySet()) {
                result.put(entry.getKey().toLowerCase(), entry.getValue().toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        double Converted_Amount=Double.parseDouble((result.get(to)))*amount;

        return Converted_Amount;

    }
}
