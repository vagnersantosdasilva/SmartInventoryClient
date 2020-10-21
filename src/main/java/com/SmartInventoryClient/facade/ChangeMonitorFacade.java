package com.SmartInventoryClient.facade;
import com.SmartInventoryClient.model.Memory;
import com.SmartInventoryClient.model.OperationalSystem;
import com.SmartInventoryClient.model.Software;
import com.SmartInventoryClient.repository.MachineRepository;
import com.SmartInventoryClient.service.MachineDTO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.executable.ValidateOnExecution;
import java.util.List;

@ValidateOnExecution
public class ChangeMonitorFacade {
    private ChangeMonitorFacade instance;
    @Autowired
    private MachineRepository machineRepository;

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
            List<Memory> memoryList = currentInventory.getMemorys();
            OperationalSystem op = currentInventory.getOperationalSystem();
            
        }
    }

    private void inventoryCacheUpdate(){

    }

}
