package com.SmartInventoryClient;

import com.SmartInventoryClient.model.MotherBoard;
import com.SmartInventoryClient.service.MotherBoardInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MotherBoardInfoServiceTest {

    @Autowired
    MotherBoardInfoService motherBoardInfoService;

    @Test
    public void motherBoardTest(){
        MotherBoard motherBoard = motherBoardInfoService.getMotherBoard();
        System.out.println("manufacturer : "+motherBoard.getManufacturer());
        System.out.println("Name : "+motherBoard.getProduct());
        System.out.println("Serial : "+motherBoard.getSerialNumber());
    }
}
