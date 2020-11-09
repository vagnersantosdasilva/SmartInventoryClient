package com.SmartInventoryClient.service;

import com.SmartInventoryClient.command.Command;
import com.SmartInventoryClient.model.Processor;
import com.SmartInventoryClient.service.DTO.ProcessorDTO;
import com.SmartInventoryClient.util.BeanUtilReflection;
import com.SmartInventoryClient.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProcessorInfoService {

    @Autowired
    BeanUtilReflection beanUtilReflection;

    @Value("${password}")
    String pass;

    public Processor getProcessor(){
        try {
            List<String> returnCommand = Command.runFromRoot("sudo dmidecode -t 4", pass.trim())
                    .stream()
                    .filter(e-> e.contains(":"))
                    .collect(Collectors.toList());
            ProcessorDTO processorDTO = (ProcessorDTO)beanUtilReflection.returnBean(returnCommand,ProcessorDTO.class,":");
            Processor processor = new Processor();
            processor.setCores(Util.convertToNumber(processorDTO.getCoreCount()));
            processor.setManufacturer(processorDTO.getManufacturer());
            processor.setMaxClock(Util.convertToNumber(processorDTO.getMaxSpeed()));
            processor.setName(processorDTO.getVersion());
            processor.setStatus(processorDTO.getStatus());

            return processor;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
}
