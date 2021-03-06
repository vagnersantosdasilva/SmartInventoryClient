package com.SmartInventoryClient.model;

import java.util.Objects;

public class MotherBoard   {


    private Integer id;
    private Integer machineId;
    private String manufacturer;
    private String product;
    private String serialNumber;
    private String status;


    public MotherBoard(Integer id, Integer machineId, String manufacturer, String product, String serialNumber, String status) {
        this.id = id;
        this.machineId = machineId;
        this.manufacturer = manufacturer;
        this.product = product;
        this.serialNumber = serialNumber;
        this.status = status;
    }

    public MotherBoard(){}


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

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MotherBoard that = (MotherBoard) o;
        return Objects.equals(getManufacturer(), that.getManufacturer()) &&
                Objects.equals(getProduct(), that.getProduct()) &&
                Objects.equals(getSerialNumber(), that.getSerialNumber()) &&
                Objects.equals(getStatus(), that.getStatus());
    }

}
