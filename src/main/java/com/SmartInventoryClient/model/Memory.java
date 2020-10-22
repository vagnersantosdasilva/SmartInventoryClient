package com.SmartInventoryClient.model;

public class Memory{


    private Integer id;
    private Integer machineId;
    private String manufacturer;
    private String type;
    private Integer size;
    private Integer frequency;

    private String slot;
    private boolean removed;


    public Memory(Integer id, Integer machineId, String manufacturer, String type, Integer size, Integer frequency,String slot, boolean removed ) {

        this.machineId = machineId;
        this.manufacturer = manufacturer;
        this.type = type;
        this.size = size;
        this.frequency = frequency;
        this.removed = removed;
        this.slot = slot;
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
}
