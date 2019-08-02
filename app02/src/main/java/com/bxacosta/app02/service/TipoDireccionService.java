package com.bxacosta.app02.service;

import com.bxacosta.app02.model.TipoDireccion;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CommonsLog
@Service
public class TipoDireccionService {

    private final String serviceId;
    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;

    public TipoDireccionService(@Value("${service.id}") String serviceId, DiscoveryClient discoveryClient) {
        this.serviceId = serviceId;
        this.discoveryClient = discoveryClient;
        this.restTemplate = new RestTemplate();
    }

    public List<TipoDireccion> findAll() {
        var instances = discoveryClient.getInstances(serviceId);

        StringBuilder sb = new StringBuilder();
        for (var instance : instances) {
            sb.append("\n");
            sb.append("-----------------------------------------------");
            sb.append("\n");
            sb.append("Host: ");
            sb.append(instance.getHost());
            sb.append("\n");
            sb.append("Port: ");
            sb.append(instance.getPort());
            sb.append("\n");
            sb.append("Uri: ");
            sb.append(instance.getUri());
            sb.append("\n");
            sb.append("-----------------------------------------------");
        }
        log.info(sb.toString());

        int index =  (int)(Math.random() * 10) % instances.size();
        var url = instances.get(index).getUri() + "/tipo";

        ResponseEntity<List<TipoDireccion>> response = this.restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<TipoDireccion>>() {
                });

        log.info("\nREQUEST TO: " + url + "\n");
        return response.getBody();
    }
}
