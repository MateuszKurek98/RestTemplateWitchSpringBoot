package org.example.itunes.proxy;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Log4j2
public class ItunesProxy {
    private final RestTemplate restTemplate;

    @Value("${itunes.service.url}")
    String url;
    @Value("${itunes.service.port}")
            //port na ktory udeżamy
    // https://itunes.apple.com:443/search?term=shawnmendes&limit=1
    int port;
    public ItunesProxy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

                            // wszystkie metody GET , PU, DELETE
    public String makeGetRequest(String term, Integer limit) {
        UriComponentsBuilder builder = UriComponentsBuilder.
                newInstance()
                .scheme("https")
                .host(url)
                .port(port)
                .path("/search")
                .queryParam("term", term)
                .queryParam("limit", limit);

        try{
            ResponseEntity<String> response = restTemplate.exchange(
                    builder.build().toUri(),
                    HttpMethod.GET,
                    null,
                    String.class
            );
            return response.getBody();
        } catch(RestClientResponseException exception){
            String message = exception.getStatusText() + " " + exception.getStatusCode().value();
            log.error(message);
        } catch(RestClientException exception){
            String message = exception.getMessage();
            log.error(message);
        }
        return null;
    }
}
