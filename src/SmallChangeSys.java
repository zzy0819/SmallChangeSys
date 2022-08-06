import java.util.Date;
import java.util.Scanner;
import java.text.*;

public class SmallChangeSys {

    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key ;
        String details = "-----明细-----";
        double money = 0;
        double balance = 0;
        double consume = 0;
        String reason = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");//用于日期格式化
        Date date = null;

        do {
        System.out.println("\n============零钱通菜单================");
        System.out.println("\t\t\t1 明细");
        System.out.println("\t\t\t2 收益入账");
        System.out.println("\t\t\t3 消费情况");
        System.out.println("\t\t\t4 退出系统");
        System.out.println("请输入你的选择");
        key = scanner.next();
        switch (key){
            case "1":
                System.out.println(details);
                break;
            case "2":
                System.out.println("收益入账");
                money = scanner.nextDouble();//输入入账金额
                balance += money;
                date =  new Date();
                //拼接信息到details中
                details += "\n收益入账\t" + money + "\t" + "入账时间:"+ sdf.format(date) + "余额:"+ balance;
                System.out.println(details);
                if (money>=0)
                    System.out.println("入账成功");
                else
                    System.out.println("入账失败，输入有误");
                break;
            case "3":
//              System.out.println("\t\t\t3 消费情况");5
                System.out.println("请输入消费原因:");
                reason = scanner.next();
                System.out.println("亲输入消费金额");
                money = scanner.nextDouble();
                if((balance  -= money)<0)
                    balance = balance;
                    System.out.println("你的余额不足");
                if((balance -= money)>0)
                    balance -= money;
                    date = new Date();
                    details += "\n消费原因\t" + reason + "\t" + "消费金额:" + money + "消费时间:" + sdf.format(date) + "余额:" +balance;
                    System.out.println(details);

                break;
            case "4":
                System.out.println("退出系统");
                loop = false;
                break;
            default:
                System.out.println("输入有误，请重新选择");
        }
    }while(loop);
    }

}
