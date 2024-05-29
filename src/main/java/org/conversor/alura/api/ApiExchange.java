package org.conversor.alura.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiExchange {


    public HttpResponse<String> exchangeRate(String currentCurrency, String exchangeCurrency) throws IOException, InterruptedException {
        String API_KEY = "6b22194e11ba27fd35e17d52";
        URI uri = URI.create("https://v6.exchangerate-api.com/v6/"+ API_KEY +"/pair/"+ currentCurrency + "/" + exchangeCurrency);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(uri)
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }


}
