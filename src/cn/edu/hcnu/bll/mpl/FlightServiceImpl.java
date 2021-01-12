package cn.edu.hcnu.bll.mpl;

import cn.edu.hcnu.bean.Flight;
import cn.edu.hcnu.dao.IFlightDao;
import cn.edu.hcnu.dao.impl.FlightDaoIml;

import java.util.Set;

public class FlightServiceImpl implements IFlightService{

        IFlightDao iFlightDao;

    public FlightServiceImpl() {
        iFlightDao=new FlightDaoIml();
    }

    @Override
    public void insertFlight(Flight flight) {
        iFlightDao.insertFlight(flight);
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
