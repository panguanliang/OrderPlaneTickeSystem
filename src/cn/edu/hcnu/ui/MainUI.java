package cn.edu.hcnu.ui;

import cn.edu.hcnu.bean.Flight;
import cn.edu.hcnu.bll.mpl.FlightServiceImpl;
import cn.edu.hcnu.bll.IFlightService;

import java.sql.SQLException;
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
                            String tableName = m.group(3);
                            String columnName = m.group(4);
                            System.out.println(tableName + "表的" + columnName + "这一列的值过大，请仔细检查");
                        } else {
                            System.out.println("NO MATCH");
                        }
                    }
                }
            }else if (choic == 2) {
                IFlightService iFlightService = new FlightServiceImpl();
                try {
                    Set<Flight> allFlights=iFlightService.getAllFlights();
                    /*
                    Set的遍历需要用到迭代器
                     */
                    for(Flight flight:allFlights){
                        System.out.println(flight);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

