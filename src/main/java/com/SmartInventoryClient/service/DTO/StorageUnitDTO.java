package com.SmartInventoryClient.service.DTO;

public class StorageUnitDTO {
    private String model;
    private String size;
    private String manufacturer;
    private boolean removible;
    private String logicalUnit;


    public String getLogicalUnit() {
        return logicalUnit;
    }

    public void setLogicalUnit(String logicalUnit) {
        this.logicalUnit = logicalUnit;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean isRemovible() {
        return removible;
    }

    public void setRemovible(boolean removible) {
        this.removible = removible;
    }
}
