package com.SmartInventoryClient.model;

import java.util.Objects;

public class OperationalSystem  {

    private Integer id;
    private Integer machineId;
    private String name;
    private String sysUpdate;
    private String hostname;
    private String status;
    private String version;
    private String installDate;



    public OperationalSystem(Integer id, Integer machineId, String name, String sysUpdate,
                             String hostname, String status, String version, String installDate) {
        this.id = id;
        this.machineId = machineId;
        this.name = name;
        this.sysUpdate = sysUpdate;
        this.hostname = hostname;
        this.status = status;
        this.version = version;
        this.installDate = installDate;

    }

    public OperationalSystem(){}


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

    public String getSysUpdate() {
        return sysUpdate;
    }

    public void setSysUpdate(String sysUpdate) {
        this.sysUpdate = sysUpdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdate() {
        return sysUpdate;
    }

    public void setUpdate(String update) {
        this.sysUpdate = update;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getInstallDate() {
        return installDate;
    }

    public void setInstallDate(String installDate) {
        this.installDate = installDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationalSystem that = (OperationalSystem) o;
        return  Objects.equals(getName(),that.getName()) &&
                Objects.equals(getSysUpdate(), that.getSysUpdate()) &&
                Objects.equals(getHostname(),that.getHostname()) &&
                Objects.equals(getStatus(), that.getStatus()) &&
                Objects.equals(getVersion(), that.getVersion()) &&
                Objects.equals(getInstallDate(), that.getInstallDate());
    }

}
