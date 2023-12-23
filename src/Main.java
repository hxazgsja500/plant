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

                } else if (p2 == 2) {
                    System.out.println("您当前用户的身份为养护人员");

                } else if (p2 == 3) {
                    System.out.println("您当前用户的身份为检测人员");

                } else {
                    System.out.println("您当前用户的身份为上层管理");
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
                                operateTable(new MonitoringResultsDAOImpl());
                                break;
                            case 2:

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

                }
            } else {
                System.out.println("密码错误 ");
            }

        }
    }

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
