package cn.edu.hcnu.dao.impl;

import cn.edu.hcnu.bean.Flight;
import cn.edu.hcnu.dao.IFlightDao;

import java.sql.*;
import java.util.Set;

public class FlightDaoIml implements IFlightDao {
    @Override

    public void insertFlight(Flight flight) throws SQLException {
        String url="jdbc:oracle:thin:@localhost:1521:orcl";
        String username="pgl";
        String password="123";
        Connection conn= DriverManager.getConnection(url,username,password);
        String sql="INSERT INTO flight VALUES(?,?,?,?,?,?,?)";

        PreparedStatement pstm=conn.prepareStatement(sql);
        pstm.setString(1,flight.getId());
        pstm.setString(2,flight.getFlightID());
        pstm.setString(3,flight.getPlaneType());
        pstm.setInt(4,flight.getCurrentSeatNum());
        pstm.setString(5,flight.getDepartureAirPort());
        pstm.setString(6,flight.getDestiantionAirPort());
        pstm.setString(7,flight.getDepartureDate());
        pstm.executeUpdate();
    }

    @Override
    public Set<Flight> getAllFlights() {
        return null;
    }

    @Override
    public Flight getFlightByDepartureTime(String departureTime) {
        return null;
    }

    @Override
    public Flight getFlightByDepartureAirPort(String departureAirPort) {
        return null;
    }

    @Override
    public Flight getFlightByDestinationAirPort(String destinationAirPort) {
        return null;
    }

    @Override
    public void updateFlight(Flight flight) {

    }
}
