package com.SmartInventoryClient;

import com.SmartInventoryClient.model.OperationalSystem;
import com.SmartInventoryClient.service.OperationalSystemInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperationalSystemInfoServiceTest {

    @Autowired
    OperationalSystemInfoService operationalSystemInfoService;

    @Test
    public void testOperationalSystem(){
        OperationalSystem op = operationalSystemInfoService.getOperationalSystem();
        System.out.println("Hostname :"+op.getHostname());
        System.out.println("Nome :"+op.getName());
        System.out.println("Sys Update : "+op.getSysUpdate());
        System.out.println("Update : "+op.getUpdate());
        System.out.println("Version "+op.getVersion());

    }
}
