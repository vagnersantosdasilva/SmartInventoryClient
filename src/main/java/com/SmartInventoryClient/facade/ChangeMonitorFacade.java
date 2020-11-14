package com.SmartInventoryClient.facade;
import com.SmartInventoryClient.model.Memory;
import com.SmartInventoryClient.model.MotherBoard;
import com.SmartInventoryClient.model.OperationalSystem;
import com.SmartInventoryClient.model.Software;
import com.SmartInventoryClient.repository.MachineRepository;
import com.SmartInventoryClient.service.*;
import com.SmartInventoryClient.service.DTO.MachineDTO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.executable.ValidateOnExecution;
import java.util.List;

@ValidateOnExecution
public class ChangeMonitorFacade {
    private ChangeMonitorFacade instance;

    @Autowired
    private MachineRepository machineRepository;

    @Autowired
    AppsInfoService appsInfoService;

    @Autowired
    MemoryInfoService memoryInfoService;

    @Autowired
    MotherBoardInfoService motherBoardInfoService;

    @Autowired
    OperationalSystemInfoService operationalSystemInfoService;

    @Autowired
    ProcessorInfoService processorInfoService;

    @Autowired
    StorageUnitInfoService storageUnitInfoService;

    @Autowired
    InventoryService inventoryService;

    public void main (){

        MachineDTO localMachine =machineRepository.getCurrentInventory();
        MachineDTO remoteMachine = proxyRemoteMachine(machineRepository.getInventoryFromCache());
        if (!remoteMachine.equals(localMachine)){

            MachineDTO releaseMachine = inventoryService.createInvetory(localMachine);
            machineRepository.saveCacheInventory(releaseMachine);
            machineRepository.saveCurrentInventory(localMachine);
        }
    }

    private MachineDTO proxyRemoteMachine(MachineDTO machine){
        if (machine==null){}
        return null;
    }

    private MachineDTO createInventory(){
        MachineDTO machine = new MachineDTO();
        machine.setMemories(memoryInfoService.getListMemorys());
        machine.setMotherBoard(motherBoardInfoService.getMotherBoard());
        machine.setOperationalSystem(operationalSystemInfoService.getOperationalSystem());
        machine.setProcessor(processorInfoService.getProcessor());
        machine.setSoftwares(appsInfoService.getListApps());
        //machine.setStorageUnits(storageUnitInfoService.getListStorageUnit());

        return machine;
    }
    private ChangeMonitorFacade(){
    }

    public ChangeMonitorFacade getInstance(){
        if (instance == null) {
            instance = new ChangeMonitorFacade();
        }
        return instance;
    }

    private void compareInventory(){
        MachineDTO currentInventory = machineRepository.getCurrentInventory();
        MachineDTO remoteInventory = machineRepository.getInventoryFromCache();
        if (!currentInventory.equals(remoteInventory)) {
            List<Software> softwareList = currentInventory.getSoftwares();
            List<Memory> memoryList = currentInventory.getMemories();
            OperationalSystem op = currentInventory.getOperationalSystem();
            
        }
    }
    private void inventoryCacheUpdate(){

    }

}
