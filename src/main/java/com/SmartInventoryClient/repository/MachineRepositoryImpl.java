package com.SmartInventoryClient.repository;

import com.SmartInventoryClient.service.DTO.MachineDTO;
import com.SmartInventoryClient.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class MachineRepositoryImpl implements MachineRepository {

    @Value("${local_inventory}")
    String currentMachine;

    @Value("${remote_inventory}")
    String remoteMachine;

    @Override
    public boolean saveCurrentInventory(MachineDTO machineDTO) {

        if (FileUtil.fileJSONWriter(machineDTO,currentMachine)) return true;
        return false;
    }

    @Override
    public boolean saveCacheInventory(MachineDTO machineDTO) {
        if (FileUtil.fileJSONWriter(machineDTO,remoteMachine)) return true;
        return false;
    }

    @Override
    public MachineDTO getInventoryFromCache() {
        MachineDTO machineDTO = (MachineDTO) FileUtil.fileJSONRead(remoteMachine);
        return machineDTO;
    }

    @Override
    public MachineDTO getCurrentInventory() {
        MachineDTO machineDTO = (MachineDTO) FileUtil.fileJSONRead(currentMachine);
        return machineDTO;
    }
}
