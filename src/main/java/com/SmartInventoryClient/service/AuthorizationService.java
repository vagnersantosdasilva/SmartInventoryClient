package com.SmartInventoryClient.service;

import com.SmartInventoryClient.constants.Constants;
import com.SmartInventoryClient.service.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthorizationService {

    private static AuthorizationService instance;
    private String authorization;

    @Autowired
    private RestTemplate restTemplate;

    public static AuthorizationService getInstance(){
        if (instance==null){
            return new AuthorizationService();
        }
        return instance;
    }

    public String getAuthorization(String username,String password,String server){
        if ((authorization==null) ){
            UserDTO user = new UserDTO(username, password);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set(Constants.CONTENT_TYPE, Constants.CONTENT_TYPE_VALUE);
            ResponseEntity<UserDTO> responseEntity = restTemplate.exchange(server, HttpMethod.POST,
                    new HttpEntity<>(user, headers), UserDTO.class);
            if (responseEntity.getStatusCode() == HttpStatus.OK){
                authorization = responseEntity.getHeaders().get(Constants.AUTHORIZATION_HEADER).get(0);
                System.out.println(authorization);
            }
            else throw new RuntimeException("Falha no processo de autenticação .");
        }
        return authorization;
    }
}
