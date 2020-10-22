package com.SmartInventoryClient.service;

import com.SmartInventoryClient.command.Command;
import com.SmartInventoryClient.service.DTO.MotherBoardDTO;
import com.SmartInventoryClient.util.BeanUtilReflection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExtractMotherBoardInfoService {

    @Autowired
    BeanUtilReflection beanUtilReflection;

    @Value("${password}")
    String pass;


    public MotherBoardDTO getMotherBoardDTO(){
        try {
            List<String> returnCommand = Command.runFromRoot("sudo dmidecode -t 2", pass.trim())
                    .stream()
                    .filter(e-> e.contains(":"))
                    .collect(Collectors.toList());
            MotherBoardDTO mb = (MotherBoardDTO)beanUtilReflection.returnBean(returnCommand,MotherBoardDTO.class,":");
            return mb;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  new MotherBoardDTO();
    }
}
