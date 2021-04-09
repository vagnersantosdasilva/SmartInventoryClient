package com.SmartInventoryClient.service;

import com.SmartInventoryClient.constants.Constants;
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
    private RestTemplate restTemplate;

    @Autowired
    private MachineRepository machineRepository;

    @Autowired
    private MemoryInfoService memoryInfoService;

    @Autowired
    private MotherBoardInfoService motherBoardInfoService;

    @Autowired
    private AppsInfoService appsInfoService;

    @Autowired
    private StorageUnitInfoService storageUnitInfoService;

    @Autowired
    AuthorizationService authorizationService;

    @Value("${login}")
    private String login;

    @Value("${password_remote}")
    private String password;

    @Value("${machine.server}")
    private String server;

    @Value("${machine.server.login}")
    private String serverLogin;

    private String authorization;

    //TODO: modificar RestTemplate para WebClient e configurar autenticação na chamada


    public MachineDTO createInvetory(MachineDTO machineDTO){

        ResponseEntity<MachineDTO> responseEntity = restTemplate.exchange(server+"/machine/create",HttpMethod.POST,
                new HttpEntity<>(machineDTO,createJSONHeader()),MachineDTO.class);

        return responseEntity.getBody();
    }

    public void updateInventory(MachineDTO machineDTO){
        try {
            HttpEntity<MachineDTO> requestEntity = new HttpEntity<MachineDTO>(machineDTO, createJSONHeader());
            ResponseEntity<MachineDTO> updateInventoryResponse = restTemplate.exchange(server + "/machine/update/{id}",
                    HttpMethod.PUT, requestEntity, MachineDTO.class, machineDTO.getId());
            //TODO: gerar um log
            System.out.println(updateInventoryResponse.getStatusCode());
        }catch(HttpStatusCodeException ex){
            System.out.println(ex.getMessage());

        }
    }

    private  HttpHeaders createJSONHeader(){
        String authorization = authorizationService.getAuthorization(login,password,serverLogin);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(Constants.CONTENT_TYPE,Constants.CONTENT_TYPE_VALUE);
        headers.set(Constants.AUTHORIZATION_HEADER,authorization);
        return headers;
    }

    public MachineDTO getMachineById(Integer machineId){

        HttpHeaders headers = createJSONHeader();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<MachineDTO> response = restTemplate.exchange(server+"/machine/"+machineId,
            HttpMethod.GET,
            entity,
            MachineDTO.class,
            machineId);
        MachineDTO machineDTO = (MachineDTO) response.getBody();
        return machineDTO;
    }


}
