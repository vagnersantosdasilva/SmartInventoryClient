package com.SmartInventoryClient;

import com.SmartInventoryClient.model.Memory;
import com.SmartInventoryClient.service.DTO.MemoryDTO;
import com.SmartInventoryClient.service.ExtractMemoryInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemorysTest {

    @Autowired
    ExtractMemoryInfoService extractMemorysInfoService;

    @Test
    public void testListMemory(){
        List<MemoryDTO> list = extractMemorysInfoService.getListMemorys();
        for (MemoryDTO memory : list){
            System.out.println();
            System.out.println("size :"+memory.getSize());
            System.out.println("type :"+memory.getType());
            System.out.println("manufacturer :"+memory.getManufacturer());
            System.out.println("serial Number :"+memory.getSerialNumber());
            System.out.println("speed :"+memory.getSpeed());
            System.out.println("locator :"+memory.getLocator());
            System.out.println("Bank Locator :"+memory.getBankLocator());
        }
    }
}
