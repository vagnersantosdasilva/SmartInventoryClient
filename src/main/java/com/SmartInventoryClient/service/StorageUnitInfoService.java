package com.SmartInventoryClient.service;

import com.SmartInventoryClient.command.Command;
import com.SmartInventoryClient.service.DTO.StorageUnitDTO;
import com.SmartInventoryClient.util.BeanUtilReflection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StorageUnitInfoService {

    @Autowired
    BeanUtilReflection beanUtilReflection;

    @Value("${password}")
    String pass;

    public List<StorageUnitDTO> getListStorageUnit() {
        try {
            List<String> returnCommand = Command.runFromRoot("sudo sh scripts/disks.sh ;sudo sh scripts/transformer.sh ",pass.trim())
                    .stream()
                    .filter(e -> e.contains(":"))
                    .collect(Collectors.toList());
            List<Object> listObject = beanUtilReflection.returnListBean(returnCommand,StorageUnitDTO.class,":");

            return listObject.stream()
                    .map(e->(StorageUnitDTO)e)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<StorageUnitDTO>();
    }

}
