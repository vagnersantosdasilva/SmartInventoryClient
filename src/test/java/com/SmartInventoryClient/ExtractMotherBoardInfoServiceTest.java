package com.SmartInventoryClient;

import com.SmartInventoryClient.model.MotherBoard;
import com.SmartInventoryClient.service.DTO.MotherBoardDTO;
import com.SmartInventoryClient.service.ExtractMotherBoardInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExtractMotherBoardInfoServiceTest {

    @Autowired
    ExtractMotherBoardInfoService extractMotherBoardInfoService;

    @Test
    public void motherBoardTest(){
        MotherBoardDTO motherBoardDTO = extractMotherBoardInfoService.getMotherBoardDTO();
        System.out.println("manufacturer : "+motherBoardDTO.getManufacturer());
        System.out.println("Name : "+motherBoardDTO.getProductName());
        System.out.println("Serial : "+motherBoardDTO.getSerialNumber());
    }
}
