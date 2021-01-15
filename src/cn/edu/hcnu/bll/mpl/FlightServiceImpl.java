package cn.edu.hcnu.bll.mpl;

import cn.edu.hcnu.bean.Flight;
import cn.edu.hcnu.bll.IFlightService;
import cn.edu.hcnu.dao.IFlightDao;
import cn.edu.hcnu.dao.impl.FlightDaoIml;

import java.sql.SQLException;
import java.util.Set;

public class FlightServiceImpl implements IFlightService {

        IFlightDao iFlightDao=new FlightDaoIml();

    public FlightServiceImpl() {
        iFlightDao=new FlightDaoIml();
    }

    @Override
    public void insertFlight(Flight flight) throws SQLException {
        this.iFlightDao.insertFlight(flight);
    }

    @Override
    public Set<Flight> getAllFlights() throws SQLException {
        return this.iFlightDao.getAllFlights();
    }

    @Override
    public Flight getFlightByDepartureTime(String departureTime) throws SQLException {
        return this.iFlightDao.getFlightByDepartureTime(departureTime);
    }

    @Override
    public Flight getFlightByDepartureAirPort(String departureAirPort) throws SQLException {
        return this.iFlightDao.getFlightByDepartureAirPort(departureAirPort);
    }

    @Override
    public Flight getFlightByDestinationAirPort(String destinationAirPort) throws SQLException {
        return this.iFlightDao.getFlightByDestinationAirPort(destinationAirPort);
    }

    @Override
    public void updateFlight(Flight flight) {

    }
}
