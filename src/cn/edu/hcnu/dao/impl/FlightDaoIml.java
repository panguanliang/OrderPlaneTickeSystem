package cn.edu.hcnu.dao.impl;

import cn.edu.hcnu.bean.Flight;
import cn.edu.hcnu.dao.IFlightDao;

import java.sql.*;
import java.util.HashSet;
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
    public Set<Flight> getAllFlights() throws SQLException {
        Set<Flight> allFlights=new HashSet<Flight>();
        String url="jdbc:oracle:thin:@localhost:1521:orcl";
        String username="pgl";
        String password="123";
        Connection conn= DriverManager.getConnection(url,username,password);
        String sql="SELECT * FROM flight";
        PreparedStatement pstm=conn.prepareStatement(sql);
        ResultSet rs=pstm.executeQuery();
        while(rs.next()){
            String id=rs.getString("ID");
            String flightID=rs.getString("FLIGHT_ID");
            String planeType=rs.getString("PLANE_TYPE");
            int currentSeatNum=rs.getInt("TOTAL_SEATS_NUM");
            String departureAirPort=rs.getString("DEPARTURE_AIRPORT");
            String destiantionAirPort=rs.getString("DESTINATION_AIRPORT");
            String departureDate=rs.getString("DEPARTURE_TIME");

            Flight flight = new Flight(id, flightID, planeType, currentSeatNum, departureAirPort, destiantionAirPort, departureDate);
            allFlights.add(flight);
        }
        return allFlights;
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
