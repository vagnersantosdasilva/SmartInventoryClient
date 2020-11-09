package com.SmartInventoryClient.model;

import java.util.Objects;

public class Memory{


    private Integer id;
    private Integer machineId;
    private String manufacturer;
    private String type;
    private Integer size;
    private Integer frequency;
    private String serialNumber;
    private String slot;
    private boolean removed;



    public Memory(Integer id, Integer machineId, String manufacturer, String type, Integer size, Integer frequency, String slot, String serialNumber, boolean removed ) {

        this.machineId = machineId;
        this.manufacturer = manufacturer;
        this.type = type;
        this.size = size;
        this.frequency = frequency;
        this.removed = removed;
        this.slot = slot;
        this.serialNumber = serialNumber;

    }
    public Memory(){}


    public String getSlot() { return slot;  }

    public void setSlot(String slot) { this.slot = slot; }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMachineId() {
        return machineId;
    }

    public void setMachineId(Integer machineId) {
        this.machineId = machineId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public boolean isRemoved() { return removed;}

    public void setRemoved(boolean removed) {  this.removed = removed;  }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Memory memory = (Memory) o;
        return isRemoved() == memory.isRemoved() &&
                Objects.equals(getManufacturer(), memory.getManufacturer()) &&
                Objects.equals(getType(), memory.getType()) &&
                getSize().equals(memory.getSize()) &&
                Objects.equals(getFrequency(), memory.getFrequency()) &&
                Objects.equals(getSlot(), memory.getSlot());
    }


}
