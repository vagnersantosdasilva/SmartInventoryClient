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


	@Test
	public void createMachineTest(){
		MachineDTO machineDTO = new MachineDTO();

		machineDTO.setMotherBoard(motherBoardInfoService.getMotherBoard());
		machineDTO.setMemories(memoryInfoService.getListMemorys());
		machineDTO.setSoftwares(appsInfoService.getListApps());
		machineDTO.setProcessor(processorInfoService.getProcessor());
		MachineDTO machine = inventoryService.createInvetory(machineDTO);

		System.out.println(machine.getId());
	}

	/*
	@Test
	public void updateProcessorTest() {

		Processor processor = new Processor();
		processor.setId(2);
		processor.setMachineId(2);
		processor.setName("Intel Pentium 4");
		processor.setArchiteture(64);
		processor.setCores(1);
		processor.setManufacturer("Intel");
		processor.setMaxClock(4000);
		processor.setStatus("OK");
		inventoryService.updateProcessor(processor);
	}

	@Test
	public void updateMemorysTest() {

		List<Memory> memoryList = inventoryService.getMachineById(2).getMemorys();
		Memory newMemory = new Memory();
		newMemory.setId(null);
		newMemory.setFrequency(800);
		newMemory.setMachineId(2);
		newMemory.setManufacturer("Kingston");
		newMemory.setRemoved(false);
		newMemory.setSize(4000);
		newMemory.setType("DDR3");
		newMemory.setSlot(("A2"));

		memoryList.add(newMemory);
		inventoryService.updateMemory(memoryList);
	}

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

			System.out.println("Memorias local  :"+machineLocal.getMemorys().size());
			System.out.println("Memorias remoto :"+machineRemote.getMemorys().size());
			System.out.println("Invent. iguais  ? "+(machineLocal.equals(machineRemote)));


	}
	*/

}
