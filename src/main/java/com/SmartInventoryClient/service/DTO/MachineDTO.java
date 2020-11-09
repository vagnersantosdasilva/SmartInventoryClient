package com.SmartInventoryClient.service.DTO;

import com.SmartInventoryClient.model.*;

import java.util.List;

public class MachineDTO {

    private Integer id;
    private List<Memory> memories;
    private Processor processor;
    private List<Software> softwares;
    private MotherBoard motherBoard;
    private OperationalSystem operationalSystem;
    private List<StorageUnit> storageUnits;


    public MachineDTO(Integer id, List<Memory> memorys, Processor processor, List<Software> softwares,
                      MotherBoard motherBoard, OperationalSystem operationalSystem, List<StorageUnit> storageUnits) {
        this.id = id;
        this.memories = memorys;
        this.processor = processor;
        this.softwares = softwares;
        this.motherBoard = motherBoard;
        this.operationalSystem = operationalSystem;
        this.storageUnits = storageUnits;
    }

    public MachineDTO(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Memory> getMemories() {
        return memories;
    }

    public void setMemories(List<Memory> memories) {
        this.memories = memories;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public List<Software> getSoftwares() {
        return softwares;
    }

    public void setSoftwares(List<Software> softwares) {
        this.softwares = softwares;
    }

    public MotherBoard getMotherBoard() {
        return motherBoard;
    }

    public void setMotherBoard(MotherBoard motherBoard) {
        this.motherBoard = motherBoard;
    }

    public OperationalSystem getOperationalSystem() {
        return operationalSystem;
    }

    public void setOperationalSystem(OperationalSystem operationalSystem) {
        this.operationalSystem = operationalSystem;
    }

    public List<StorageUnit> getStorageUnits() {
        return storageUnits;
    }

    public void setStorageUnits(List<StorageUnit> storageUnits) {
        this.storageUnits = storageUnits;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MachineDTO that = (MachineDTO) o;
        return  getProcessor().equals(that.getProcessor()) &&
                getMotherBoard().equals(that.getMotherBoard()) &&
                getOperationalSystem().equals(that.getOperationalSystem()) ;
    }

}
