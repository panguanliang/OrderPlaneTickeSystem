package cn.edu.hcnu.bean;

import java.util.Set;

public class Flight {
    private String id;
    private String planeType;//飞机型号
    private String currentSeatNum;//总座位数
    private String departureAirPort;//出发机场
    private String destiantionAirPort;//到达机场
    private String departureDate;//出发时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public String getCurrentSeatNum() {
        return currentSeatNum;
    }

    public void setCurrentSeatNum(String currentSeatNum) {
        this.currentSeatNum = currentSeatNum;
    }

    public String getDepartureAirPort() {
        return departureAirPort;
    }

    public void setDepartureAirPort(String departureAirPort) {
        this.departureAirPort = departureAirPort;
    }

    public String getDestiantionAirPort() {
        return destiantionAirPort;
    }

    public void setDestiantionAirPort(String destiantionAirPort) {
        this.destiantionAirPort = destiantionAirPort;
    }

    public String getDepartureData() {
        return departureDate;
    }

    public void setDepartureData(String departureData) {
        this.departureDate = departureData;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }
}
