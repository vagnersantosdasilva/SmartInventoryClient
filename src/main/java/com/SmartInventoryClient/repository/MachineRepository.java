package com.SmartInventoryClient.repository;

import com.SmartInventoryClient.service.DTO.MachineDTO;


public interface MachineRepository {

    public boolean saveCurrentInventory(MachineDTO machineDTO);
    public boolean saveCacheInventory(MachineDTO machineDTO);
    public MachineDTO getInventoryFromCache();
    public MachineDTO getCurrentInventory();

}
