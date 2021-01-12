package cn.edu.hcnu.ui;

import cn.edu.hcnu.bean.Flight;
import cn.edu.hcnu.bll.mpl.FlightServiceImpl;
import cn.edu.hcnu.bll.mpl.IFlightService;
import cn.edu.hcnu.dao.impl.FlightDaoIml;

import java.util.Scanner;
import java.util.Set;
import java.util.UUID;

public class MainUI {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("按1，录入航班信息");
        System.out.println("按2，显示所有航班信息");
        System.out.println("按3，查看航班信息");
        System.out.println("按4，机票预定");
        System.out.println("按5，机票退改");
        System.out.println("按6，退出系统");
        int choic=sc.nextInt();
        if(choic==1) {
            String id= UUID.randomUUID().toString();
            System.out.print("请输入航班编号：");
            String flightId = sc.next();
            System.out.print("请输入机型：");
            String planeType = sc.next();
            System.out.print("请输入座位数：");
            int currentSeatsNum = sc.nextInt();
            System.out.print("请输入起飞机场：");
            String departureAirPort = sc.next();
            System.out.print("请输入目的机场：");
            String destinationAirPort = sc.next();
            System.out.print("请输入起飞时间：");
            String departureTime = sc.next();

            Flight flight = new Flight(flightId, planeType, currentSeatsNum, departureAirPort, destinationAirPort,departureTime);

            IFlightService iFlightService=new FlightServiceImpl();
            iFlightService.insertFlight(flight);
        }
    }
}

