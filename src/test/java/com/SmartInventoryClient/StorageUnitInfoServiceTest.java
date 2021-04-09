package com.SmartInventoryClient;

import com.SmartInventoryClient.model.StorageUnit;
import com.SmartInventoryClient.service.DTO.StorageUnitDTO;
import com.SmartInventoryClient.service.StorageUnitInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StorageUnitInfoServiceTest {

    @Autowired
    StorageUnitInfoService storageUnitInfoService;

    @Test
    public void testServiceDisk(){

        List<StorageUnit> diskDTOList = storageUnitInfoService.getListStorageUnit();
        for (StorageUnit disk : diskDTOList){

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
