package com.SmartInventoryClient;

import com.SmartInventoryClient.service.DTO.StorageUnitDTO;
import com.SmartInventoryClient.service.ExtractStorageUnitInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExtractStorageUnitInfoServiceTest {

    @Autowired
    ExtractStorageUnitInfoService extractStorageUnitInfoService;

    @Test
    public void testServiceDisk(){

        List<StorageUnitDTO> diskDTOList = extractStorageUnitInfoService.getListStorageUnit();
        for (StorageUnitDTO disk : diskDTOList){

            System.out.println();
            System.out.println("model : "+disk.getModel());
            System.out.println("size : "+disk.getSize());
            System.out.println("manufacturer : "+disk.getManufacturer());
            System.out.println("removible : "+disk.isRemovible());
            System.out.println("logical unit : "+disk.getLogicalUnit());
            System.out.println();
        }

    }
}
