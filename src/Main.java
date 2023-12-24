import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.println(
                    "-----------------------------------植物登陆-----------------------------------\n" +
                            "请输入用户名:");
            Scanner sc0 = new Scanner(System.in);
            String username = sc0.next();
            System.out.println("请输入密码:");
            sc0 = new Scanner(System.in);
            String pwd = sc0.nextLine().trim();  // 修剪掉首尾空格
            String p1 = DAOFactory.getInstance().getuserDAO().getPwd(username).trim();  // 修剪数据库中的密码
            if (pwd.equals(p1)) {
                System.out.println("登录成功");
                int p2 = DAOFactory.getInstance().getuserDAO().gettype(username);

                if (p2 == 1) {
                    System.out.println("您当前用户的身份为系统管理员");
                    Scanner scanner = new Scanner(System.in);
                    //选择要操作的表
                    while (true) {
                        System.out.println("请选择要操作的表：");
                        System.out.println("1. MonitoringResults");
                        System.out.println("2. Pests");
                        System.out.println("3. Plants");
                        System.out.println("4. Classification");
                        System.out.println("5. Maintenance");
                        System.out.println("0. 退出");

                        System.out.print("请输入选项：");
                        int choice = scanner.nextInt();

                        if (choice == 0) {
                            System.out.println("感谢使用，再见！");
                            break;
                        }

                        switch (choice) {
                            case 1:
                                //监测表改动
                                operateTable(new MonitoringResultsDAOImpl());
                                break;
                            case 2:
                                //病虫害表改动

                                break;
                            case 3:

                                break;
                            case 4:

                                break;
                            case 5:

                                break;
                            default:
                                System.out.println("无效的选项，请重新输入！");
                        }
                    }
                } else if (p2 == 2) {
                    System.out.println("您当前用户的身份为养护人员");

                } else if (p2 == 3) {
                    System.out.println("您当前用户的身份为检测人员");
                    //监测表改动
                    operateTable(new MonitoringResultsDAOImpl());
                } else {
                    System.out.println("您当前用户的身份为上层管理");
                    Scanner scanner = new Scanner(System.in);

                    while (true) {
                        // 打印菜单选项
                        System.out.println("===== 主菜单 =====");
                        System.out.println("1. 查看养护人员信息");
                        System.out.println("2. 查看监测人员信息");
                        System.out.println("3. 查看养护结果");
                        System.out.println("4. 查看园林植物养护信息");
                        System.out.println("5. 查看植物分类信息");
                        System.out.println("6. 查看植物基本信息");
                        System.out.println("0. 退出程序");
                        System.out.print("请输入选项编号: ");
                        // 读取用户输入
                        int choice = scanner.nextInt();
                        // 根据用户选择执行相应操作
                        switch (choice) {
                            case 1:
                                // 执行查看养护人员信息的操作
                                System.out.println("查看养护人员信息...");
                                MaintenanceDAO maintenanceDAO = new MaintenanceDAOImpl();
                                // 查询所有养护任务
                                List<Maintenance> maintenanceList = maintenanceDAO.getAllMaintenance();
                                for (Maintenance maintenance : maintenanceList) {
                                    System.out.println(maintenance);
                                }
                                break;
                            case 2:
                                // 执行查看监测人员信息的操作
                                System.out.println("查看监测人员信息...");
                                MonitoringDAO monitoringDAO = new MonitoringDAOImpl();
                                // 查询所有检测信息
                                List<Monitoring> monitoringList = monitoringDAO.getAllMonitoring();
                                for (Monitoring monitoring : monitoringList) {
                                    System.out.println(monitoring);
                                }
                                break;
                            case 3:
                                // 执行查看养护结果的操作
                                System.out.println("查看养护结果...");
                                MonitoringResultsDAO monitoringResultsDAO = new MonitoringResultsDAOImpl();
                                // 查询所有检测信息
                                List<MonitoringResult> monitoringResultsList = monitoringResultsDAO.getAllResults();
                                for (MonitoringResult MonitoringResult : monitoringResultsList) {
                                    System.out.println(MonitoringResult);
                                }
                                break;
                            case 4:
                                // 执行查看园林植物养护信息的操作
                                System.out.println("查看园林植物养护信息...");
                                PlantCareDAO plantCareDAO = new PlantCareDAOImpl();
                                // 查询所有园林植物养护信息
                                List<PlantCare> plantCareList = plantCareDAO.getAllPlantCare();
                                for (PlantCare plantCare : plantCareList) {
                                    System.out.println(plantCare);
                                }
                                break;
                            case 5:
                                // 执行查看植物分类信息的操作
                                System.out.println("查看植物分类信息...");
                                ClassificationDAO classificationDAO = new ClassificationDAOImpl();
                                List<Classification> classifications = classificationDAO.getAllClassifications();
                                for (Classification classification : classifications) {
                                    System.out.println(classification);
                                }
                                break;
                            case 6:
                                // 执行查看植物基本信息的操作
                                System.out.println("查看植物基本信息...");
                                PlantDAO plantDAO = new PlantDAOImpl();
                                List<Plant> plantList = plantDAO.getAllPlants();
                                for (Plant Plant : plantList) {
                                    System.out.println(Plant);
                                }
                                break;
                            case 0:
                                // 退出程序
                                System.out.println("退出程序。");
                                System.exit(0);
                                break;
                            default:
                                // 处理无效选项
                                System.out.println("无效的选项，请重新输入。");
                        }
                    }
                }
            } else {
                System.out.println("密码错误 ");
            }
        }
    }
    //检测结果表用法的目录及函数operateTable
    private static void operateTable(MonitoringResultsDAOImpl monitoringResultsDAO) {
        //对检测表的操作，对监测ID MonitoringID，监测指标ID IndicatorID，结果数值类型 ResultValue 的操作
        Scanner scanner = new Scanner(System.in);
        // 提示用户选择操作
        System.out.println("请选择操作：");
        System.out.println("1. 查询数据");
        System.out.println("2. 插入数据");
        System.out.println("3. 更新数据");
        System.out.println("4. 删除数据");
        System.out.print("请输入操作编号：");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // 查询数据
                List<MonitoringResult> results = monitoringResultsDAO.getAllResults();
                for (MonitoringResult result : results) {
                    System.out.println(result);
                }
                break;
            case 2:
                // 插入数据
                System.out.print("请输入MonitoringID：");
                int monitoringID = scanner.nextInt();
                System.out.print("请输入IndicatorID：");
                int indicatorID = scanner.nextInt();
                System.out.print("请输入ResultValue：");
                double resultValue = scanner.nextDouble();

                MonitoringResult newResult = new MonitoringResult();
                newResult.setMonitoringID(monitoringID);
                newResult.setIndicatorID(indicatorID);
                newResult.setResultValue(resultValue);

                monitoringResultsDAO.insertResult(newResult);
                break;
            case 3:
                // 更新数据
                System.out.print("请输入要更新的ResultID：");
                int updateResultID = scanner.nextInt();
                System.out.print("请输入新的ResultValue：");
                double newResultValue = scanner.nextDouble();

                MonitoringResult updatedResult = new MonitoringResult();
                updatedResult.setResultID(updateResultID);
                updatedResult.setResultValue(newResultValue);

                monitoringResultsDAO.updateResult(updatedResult);
                break;
            case 4:
                // 删除数据
                System.out.print("请输入要删除的ResultID：");
                int deleteResultID = scanner.nextInt();
                monitoringResultsDAO.deleteResult(deleteResultID);
                break;
            default:
                System.out.println("无效的操作编号");
        }
    }
}


