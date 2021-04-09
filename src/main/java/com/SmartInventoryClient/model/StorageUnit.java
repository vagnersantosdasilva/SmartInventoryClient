package com.SmartInventoryClient.model;

import java.util.Objects;

public class StorageUnit {
    private Integer id;
    private Integer machineId;
    private String model;
    private String size;
    private String manufacturer;
    private boolean removible;
    private String logicalUnit;

    public StorageUnit(String model, String size, String manufacturer, boolean removible, String logicalUnit) {
        this.model = model;
        this.size = size;
        this.manufacturer = manufacturer;
        this.removible = removible;
        this.logicalUnit = logicalUnit;
    }

    public StorageUnit(){}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorageUnit that = (StorageUnit) o;
        return isRemovible() == that.isRemovible() &&
                getModel().equals(that.getModel()) &&
                getSize().equals(that.getSize()) &&
                getManufacturer().equals(that.getManufacturer()) &&
                getLogicalUnit().equals(that.getLogicalUnit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModel(), getSize(), getManufacturer(), isRemovible(), getLogicalUnit());
    }
}
