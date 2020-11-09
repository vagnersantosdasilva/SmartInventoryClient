package com.SmartInventoryClient;

import com.SmartInventoryClient.model.Processor;
import com.SmartInventoryClient.service.ProcessorInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExtractProcessorServiceTest {

    @Autowired
    ProcessorInfoService processorInfoService;

    @Test
    public void testServiceProcessor(){
        Processor processor = processorInfoService.getProcessor();
        System.out.println("manufacturer : "+processor.getManufacturer());
        System.out.println("name  : "+processor.getName());
        System.out.println("n cores  : "+processor.getCores());
        System.out.println("clock : "+processor.getMaxClock());
        System.out.println("architeture : "+processor.getArchiteture());
        System.out.println("status : "+processor.getStatus());
    }
}
