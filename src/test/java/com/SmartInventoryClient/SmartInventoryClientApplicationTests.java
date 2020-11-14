package com.SmartInventoryClient;

import com.SmartInventoryClient.repository.MachineRepository;
import com.SmartInventoryClient.service.*;
import com.SmartInventoryClient.service.DTO.MachineDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmartInventoryClientApplicationTests {

	@Autowired
	InventoryService inventoryService;

	@Autowired
	MachineRepository machineRepository;

	@Autowired
    AppsInfoService appsInfoService;

	@Autowired
	MotherBoardInfoService motherBoardInfoService;

	@Autowired
	MemoryInfoService memoryInfoService;

	@Autowired
	ProcessorInfoService processorInfoService;

/*
	@Test
	public void createMachineTest(){
		MachineDTO machineDTO = new MachineDTO();

		machineDTO.setMotherBoard(motherBoardInfoService.getMotherBoard());
		machineDTO.setMemories(memoryInfoService.getListMemorys());
		machineDTO.setSoftwares(appsInfoService.getListApps());
		machineDTO.setProcessor(processorInfoService.getProcessor());

		MachineDTO machine = inventoryService.createInvetory(machineDTO);
		machineRepository.saveCacheInventory(machine);
		machineRepository.saveCurrentInventory(machineDTO);


		System.out.println(machine.getId());

		assertEquals(machine.getMotherBoard(),machineDTO.getMotherBoard());
		assertEquals(machine.getOperationalSystem(),machineDTO.getOperationalSystem());
		assertEquals(machine.getProcessor(),machineDTO.getProcessor());
		assertEquals(machineRepository.getCurrentInventory(),machineRepository.getInventoryFromCache());
		System.out.println(machine.equals(machineDTO));
	}*/


	@Test
	public void updateMachine(){

		MachineDTO remoteMachine = machineRepository.getInventoryFromCache();
		MachineDTO localMachine = machineRepository.getCurrentInventory();
		System.out.println(remoteMachine.equals(localMachine));


	}
	/*
	@Test
	public void getMachineTest(){
		MachineDTO machineDTO = inventoryService.getMachineById(2);
		System.out.println("From remote :"+machineDTO.getOperationalSystem().getName());
	}

	@Test
	public void getMachineFromFile(){
		MachineDTO cacheInvenotry = machineRepository.getInventoryFromCache();
		MachineDTO localInventory = machineRepository.getCurrentInventory();
		System.out.println("From Cache :"+cacheInvenotry.getOperationalSystem().getName());
		System.out.println("From File :"+localInventory.getOperationalSystem().getName());
	}

	@Test
	public void saveCacheTest(){
		MachineDTO machineDTO = inventoryService.getMachineById(2);
		machineRepository.saveCacheInventory(machineDTO);
		MachineDTO cacheInvenotry = machineRepository.getInventoryFromCache();
		System.out.println("MachineID : "+cacheInvenotry.getOperationalSystem().getMachineId());

	}

	@Test
	public void checkChange() {
		MachineDTO machineLocal = machineRepository.getInventoryFromCache();
		MachineDTO machineRemote = machineRepository.getCurrentInventory();


	}*/


}
