package com.SmartInventoryClient.service;

import com.SmartInventoryClient.repository.MachineRepository;
import com.SmartInventoryClient.service.DTO.MachineDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Service
public class InventoryService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MachineRepository machineRepository;

    @Autowired
    MemoryInfoService memoryInfoService;

    @Autowired
    MotherBoardInfoService motherBoardInfoService;

    @Autowired
    AppsInfoService appsInfoService;

    @Autowired
    StorageUnitInfoService storageUnitInfoService;



    @Value("${machine.server}")
    String server;

    public MachineDTO createInvetory(MachineDTO machineDTO){
        ResponseEntity<MachineDTO> responseEntity = restTemplate.exchange(server+"/machine/create",HttpMethod.POST,
                new HttpEntity<>(machineDTO,createJSONHeader()),MachineDTO.class);

        return responseEntity.getBody();
    }

    public void updateInventory(MachineDTO machineDTO){
        try {
            HttpEntity<MachineDTO> requestEntity = new HttpEntity<MachineDTO>(machineDTO, createJSONHeader());
            ResponseEntity<MachineDTO> updateInventoryResponse = restTemplate.exchange(server + "machine/update/{id}", HttpMethod.PUT, requestEntity, MachineDTO.class, machineDTO.getId());
            //gerar um log aqui
            System.out.println(updateInventoryResponse.getStatusCode());
        }catch(HttpStatusCodeException ex){
            System.out.println(ex.getMessage());

        }
    }

    private static HttpHeaders createJSONHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
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
