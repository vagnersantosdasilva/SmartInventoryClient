package com.SmartInventoryClient;

import com.SmartInventoryClient.model.Memory;
import com.SmartInventoryClient.model.Processor;
import com.SmartInventoryClient.service.InventoryService;
import com.SmartInventoryClient.service.MachineDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmartInventoryClientApplicationTests {

	@Autowired
	InventoryService inventoryService;

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
	public void updateMemorysTest(){

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
		System.out.println(machineDTO.getOperationalSystem().getName());
	}

}
