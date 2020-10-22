package com.SmartInventoryClient.service;

import com.SmartInventoryClient.command.Command;
import com.SmartInventoryClient.service.DTO.MemoryDTO;
import com.SmartInventoryClient.util.BeanUtilReflection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExtractMemoryInfoService {

    @Autowired
    BeanUtilReflection beanUtilReflection ;

    @Value("${password}")
    String pass;

    public List<MemoryDTO> getListMemorys() {

        try {
            List<String> returnCommand = Command.runFromRoot("sudo dmidecode -t 17", pass.trim())
                    .stream()
                    .filter(e -> e.contains(":"))
                    .collect(Collectors.toList());
            List<Object> list = beanUtilReflection.returnListBean(
                    returnCommand,MemoryDTO.class,":"
            );

            return list.stream()
                    .map(e->(MemoryDTO)e)
                    .collect(Collectors.toList());

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
