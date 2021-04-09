package com.SmartInventoryClient;

import com.SmartInventoryClient.constants.Constants;
import com.SmartInventoryClient.service.DTO.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Login {

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void login(){
        UserDTO user = new UserDTO("fernanda@gmail.com","abc@123");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(Constants.CONTENT_TYPE,Constants.CONTENT_TYPE_VALUE);
        ResponseEntity<UserDTO> responseEntity = restTemplate.exchange("http://localhost:8080/login", HttpMethod.POST,
                new HttpEntity<>(user,headers),UserDTO.class);
        List<String> response = responseEntity.getHeaders().get(Constants.AUTHORIZATION_HEADER);
        if (responseEntity.getStatusCode() == HttpStatus.OK) System.out.println("Status :"+HttpStatus.OK);
        for (String s:response){
            System.out.println(s);
        }
    }
}
