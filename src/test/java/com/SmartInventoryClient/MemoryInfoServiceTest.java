package com.SmartInventoryClient;

import com.SmartInventoryClient.model.Memory;
import com.SmartInventoryClient.service.MemoryInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemoryInfoServiceTest {

    @Autowired
    MemoryInfoService extractMemorysInfoService;

    @Test
    public void testListMemory(){
        List<Memory> list = extractMemorysInfoService.getListMemorys();
        for (Memory memory : list){
            System.out.println();
            System.out.println("size :"+memory.getSize());
            System.out.println("type :"+memory.getType());
            System.out.println("manufacturer :"+memory.getManufacturer());
            System.out.println("serial Number :"+memory.getSerialNumber());
            System.out.println("speed :"+memory.getFrequency());
            System.out.println("locator :"+memory.getSlot());

        }
    }
}
