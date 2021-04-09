package com.SmartInventoryClient;

import com.SmartInventoryClient.service.AuthorizationService;
import com.SmartInventoryClient.service.DTO.MachineDTO;
import com.SmartInventoryClient.service.InventoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InventoryServiceTest {

    @Autowired
    InventoryService inventoryService;

    @Autowired
    AuthorizationService authorizationService;

    @Test
    public void getTokenInstance(){
        System.out.println(
                authorizationService.getAuthorization("fernanda@gmail.com","abc@123","http://localhost:8080/login"
                )
        );

        System.out.println(
                authorizationService.getAuthorization("fernanda@gmail.com","abc@123","http://localhost:8080/login"
                )
        );
    }

    @Test
    public void getMachine(){
        MachineDTO machineDTO = inventoryService.getMachineById(1);
        Assert.assertEquals("1",machineDTO.getId().toString());

    }
}
