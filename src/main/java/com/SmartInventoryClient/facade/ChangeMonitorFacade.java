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
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

        MachineDTO localMachine =createInventory();//machineRepository.getCurrentInventory();
        MachineDTO remoteMachine = (cacheRemoteMachine(localMachine));
        if (remoteMachine!=null && (!remoteMachine.equals(localMachine))){
            System.out.println("Diferenças encontradas em inventarios...");
            localMachine = updateLists(localMachine,remoteMachine);
            MachineDTO releaseMachine = setId(localMachine,remoteMachine);

            inventoryService.updateInventory(releaseMachine);
            remoteMachine = inventoryService.getMachineById(releaseMachine.getId());
            machineRepository.saveCacheInventory(remoteMachine);
            //machineRepository.saveCurrentInventory(localMachine);
        }
    }

    private MachineDTO cacheRemoteMachine(MachineDTO machineDTO){
        if (machineRepository.getInventoryFromCache()==null){
            MachineDTO newMachine = inventoryService.createInvetory(machineDTO);
            machineRepository.saveCacheInventory(newMachine);
            machineRepository.saveCurrentInventory(newMachine);
            return newMachine;
        }
        return machineRepository.getInventoryFromCache();
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

    //Todo: problema ao mudar lista de software. Passagem de objeto inexistente causa index out
    private MachineDTO setId(MachineDTO receiver,MachineDTO send ){
        receiver.setId(send.getId());
        receiver.getProcessor().setId(send.getId());
        receiver.getMotherBoard().setId(send.getId());
        receiver.getOperationalSystem().setId(send.getId());
        receiver.getMemories().stream()
                .map( e -> {
                    if (send.getMemories().contains(e)){
                        Integer i = send.getMemories().indexOf(e);
                        e.setId(send.getMemories().get(i).getId());
                        e.setMachineId(send.getMemories().get(i).getMachineId());
                    }
                    return e;
                }).collect(Collectors.toList());

        receiver.getSoftwares().stream()
                .map(e-> {
                    if(send.getSoftwares().contains(e)){
                        Integer i = send.getSoftwares().indexOf(e);
                        e.setId(send.getSoftwares().get(i).getId());
                        e.setMachineId(send.getSoftwares().get(i).getMachineId());
                    }
                    return e;
                }).collect(Collectors.toList());

        return  receiver;
    }

    private MachineDTO updateLists(MachineDTO instant,MachineDTO previw ){
        List<Memory> newMemories =  instant.getMemories().stream()
                .filter( e -> !previw.getMemories().contains(e) )
                .collect(Collectors.toList());
        List<Memory> removeMemories = previw.getMemories().stream()
                .filter(e-> !instant.getMemories().contains(e))
                .map( e-> {
                    e.setRemoved(true);
                    return e;
                })
                .collect(Collectors.toList());
        removeMemories.addAll(newMemories);
        instant.setMemories(removeMemories);


        List<Software> newSoftwares = instant.getSoftwares().stream()
                .filter(e->!previw.getSoftwares().contains(e))
                .map( e->{
                    e.setInstallDate(new Date().toString());
                    e.setDeleted(false);
                    return  e;
                })
                .collect(Collectors.toList());

        List<Software> removeSoftware = previw.getSoftwares().stream()
                .filter(e-> !instant.getSoftwares().contains(e))
                .map( e-> {
                    e.setDeleted(true);
                    e.setDeleteDate(new Date().toString());
                    return e;
                })
                .collect(Collectors.toList());
        removeSoftware.addAll(newSoftwares);
        instant.setSoftwares(removeSoftware);

        return instant;

    }


}
