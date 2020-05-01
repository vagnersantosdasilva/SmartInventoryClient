package com.SmartInventoryClient.service;

import com.SmartInventoryClient.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${machine.server}")
    String server;


    public void updateProcessor(Processor processor) {

        restTemplate.put(server+"/processor/update", processor);
    }

    public void updateMemory(List<Memory> listMemory){

        restTemplate.put(server+"/memory/update",listMemory);
    }

    public void motherBoardUpdate(MotherBoard motherBoard){
        restTemplate.put(server+"/mother_board/update",motherBoard);
    }

    public void updateOS(OperationalSystem os){
        restTemplate.put(server+"/operational_system/update",os);
    }

    public void updateSoftwares(List<Software> softwareList){
        restTemplate.put(server+"/softwares/update",softwareList);
    }

    public MachineDTO getMachineById(Integer machineId){
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<?> responseEntity = restTemplate.exchange(server+"/machine/"+machineId,
                HttpMethod.GET,
                null,
                MachineDTO.class);
        MachineDTO machineDTO = (MachineDTO) responseEntity.getBody();
        return machineDTO;
    }

}
