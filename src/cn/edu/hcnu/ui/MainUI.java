package cn.edu.hcnu.ui;

import cn.edu.hcnu.bean.Flight;
import cn.edu.hcnu.bll.mpl.FlightServiceImpl;
import cn.edu.hcnu.bll.IFlightService;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainUI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("按1，录入航班信息");
            System.out.println("按2，显示所有航班信息");
            System.out.println("按3，查看航班信息");
            System.out.println("按4，机票预定");
            System.out.println("按5，机票退改");
            System.out.println("按6，退出系统");
            int choic = sc.nextInt();
            String departureTimes;
            String departureAirPorts;
            String destinationAirPorts;
            if (choic == 1) {
                String id = UUID.randomUUID().toString().replace("-", "");
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

                Flight flight = new Flight(id, flightId, planeType, currentSeatsNum, departureAirPort, destinationAirPort, departureTime);

                IFlightService iFlightService = new FlightServiceImpl();
                try {
                    iFlightService.insertFlight(flight);
                } catch (SQLException e) {
                    String errorMessage = e.getMessage();
                    System.out.println(errorMessage);
                    if (errorMessage.startsWith("ORA-12899")) {
                        //ORA-12899: 列 "PGL"."FLIGHT"."ID" 的值太大 (实际值: 32, 最大值: 30)
                        // 按指定模式在字符串查找
                        String pattern = "(\\W)+\\s(\"\\w+\")\\.(\"\\w+\")\\.(\"\\w+\")";
                        // 创建 Pattern 对象
                        Pattern r = Pattern.compile(pattern);
                        // 现在创建 matcher 对象
                        Matcher m = r.matcher(errorMessage);
                        if (m.find()) {
                            System.out.println(m.group(1));
                            System.out.println(m.group(2));
                            String tableName = m.group(3);
                            String columnName = m.group(4);
                            System.out.println(tableName + "表的" + columnName + "这一列的值过大，请仔细检查");
                        } else {
                            System.out.println("NO MATCH");
                        }
                    }
                }
            } else {
                Flight flight;
                if (choic == 2) {
                    IFlightService iFlightService = new FlightServiceImpl();
                    try {
                        Set<Flight> allFlights = iFlightService.getAllFlights();
                        Iterator var25 = allFlights.iterator();
                    /*
                    Set的遍历需要用到迭代器
                     */
                        while (var25.hasNext()) {
                            flight = (Flight) var25.next();
                            System.out.println(flight);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                else if(choic==3) {
                    Flight flight1;
                    System.out.println("输入相应信息查询航班信息");
                    System.out.println("1，按起飞时间查询");
                    System.out.println("2，按起飞地查询");
                    System.out.println("3，按目的地查询");
                    System.out.println("4，按空座数查询");
                    int chooes=sc.nextInt();
                    switch (chooes){

                        case 1:
                            System.out.println("输入起飞时间");
                            departureTimes=sc.next();
                            FlightServiceImpl flightService=new FlightServiceImpl();
                            try {
                                flight1=flightService.getFlightByDepartureTime(departureTimes);
                                if (flight1!=null){
                                    System.out.println("输出查询结果:"+flight1);
                                }
                                else System.out.println("未查询到该时间段的航班");
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 2:
                            System.out.println("输入起飞地点");
                            departureAirPorts=sc.next();
                            FlightServiceImpl flightService1=new FlightServiceImpl();
                            try {
                                flight1=flightService1.getFlightByDepartureAirPort(departureAirPorts);
                                if (flight1!=null){
                                    System.out.println("输出查询结果:"+flight1);
                                }
                                else System.out.println("未查询到该时间段的航班");
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 3:
                            System.out.println("输入目的地地点");
                            destinationAirPorts=sc.next();
                            FlightServiceImpl flightService2=new FlightServiceImpl();
                            try {
                                flight1=flightService2.getFlightByDepartureAirPort(destinationAirPorts);
                                if (flight1!=null){
                                    System.out.println("输出查询结果:"+flight1);
                                }
                                else System.out.println("未查询到该时间段的航班");
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            break;
                    }
                }
            }
        }
    }
}

