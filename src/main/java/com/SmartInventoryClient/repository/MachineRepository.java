package com.SmartInventoryClient.repository;

import com.SmartInventoryClient.service.MachineDTO;
import com.SmartInventoryClient.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class MachineRepository {

    @Value("${local_inventory}")
    String currentMachine;

    @Value("${remote_inventory}")
    String remoteMachine;

    public boolean  saveRemoteMachineInFileJSON(MachineDTO machineDTO){
        if (FileUtil.fileJSONWriter(remoteMachine)) return true;
        return false;
    }

    public boolean  saveCurrentMachineInFileJSON(MachineDTO machineDTO){
        if (FileUtil.fileJSONWriter(currentMachine)) return true;
        return false;
    }

    public MachineDTO getMachineDTOFromFile(){
        MachineDTO machineDTO = (MachineDTO) FileUtil.fileJSONRead(currentMachine);
        return machineDTO;
    }
}
