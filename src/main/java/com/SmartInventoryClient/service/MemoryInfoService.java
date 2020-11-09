package com.SmartInventoryClient.service;

import com.SmartInventoryClient.command.Command;
import com.SmartInventoryClient.model.Memory;
import com.SmartInventoryClient.service.DTO.MemoryDTO;
import com.SmartInventoryClient.util.BeanUtilReflection;
import com.SmartInventoryClient.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.SmartInventoryClient.util.Util.convertToNumber;

@Service
public class MemoryInfoService {

    @Autowired
    BeanUtilReflection beanUtilReflection ;

    @Value("${password}")
    String pass;

    public List<Memory> getListMemorys() {

        try {
            List<String> returnCommand = Command.runFromRoot("sudo dmidecode -t 17", pass.trim())
                    .stream()
                    .filter(e -> e.contains(":"))
                    .collect(Collectors.toList());
            List<Object> list = beanUtilReflection.returnListBean(
                    returnCommand,MemoryDTO.class,":"
            );

            List<MemoryDTO>memories = list.stream()
                    .map(e->(MemoryDTO)e)
                    .collect(Collectors.toList());

            List<Memory> listMemory = new ArrayList<>();
            for (MemoryDTO memDTO :memories){
                Memory memory = new Memory();
                memory.setManufacturer(memDTO.getManufacturer());
                memory.setFrequency(Util.convertToNumber(memDTO.getSpeed()));
                memory.setSlot(memDTO.getBankLocator());
                memory.setSerialNumber(memDTO.getSerialNumber());
                memory.setType(memDTO.getType());
                memory.setSize(Util.convertToNumber(memDTO.getSize()));
                listMemory.add(memory);
            }

            return listMemory;

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }



}
