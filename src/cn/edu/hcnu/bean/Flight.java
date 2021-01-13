package cn.edu.hcnu.bean;

import java.util.Set;

public class Flight {
    private String id;
    private String flightID;
    private String planeType;//飞机型号
    private int currentSeatNum;//总座位数
    private String departureAirPort;//出发机场
    private String destiantionAirPort;//到达机场
    private String departureDate;//出发时间

    public Flight(String id, String flightID, String planeType, int currentSeatNum, String departureAirPort, String destiantionAirPort, String departureDate) {
        this.id = id;
        this.flightID = flightID;
        this.planeType = planeType;
        this.currentSeatNum = currentSeatNum;
        this.departureAirPort = departureAirPort;
        this.destiantionAirPort = destiantionAirPort;
        this.departureDate = departureDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public int getCurrentSeatNum() {
        return currentSeatNum;
    }

    public void setCurrentSeatNum(int currentSeatNum) {
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

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    @Override
    public String toString() {
        return "航班信息{" +
                "航班编号='" + flightID + '\'' +
                ", 机型='" + planeType + '\'' +
                ", 座位数=" + currentSeatNum +
                ", 起飞机场='" + departureAirPort + '\'' +
                ", 目的机场='" + destiantionAirPort + '\'' +
                ", 起飞时间='" + departureDate + '\'' +
                '}';
    }
}
