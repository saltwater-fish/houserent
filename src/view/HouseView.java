package view;


import domain.House;
import service.HouseService;

import java.util.Scanner;

public class HouseView {

    private boolean loop = true;
    private HouseService houseService = new HouseService(6);

    // 显示主菜单
    public void mainMenu(){
        //变量
        String key = "";
        Scanner scanner = new Scanner(System.in);


        while (loop) {
            // 1、显示界面
            System.out.println("--------------------------房屋出租系统-----------------------------");
            System.out.println("\t\t\t\t\t1 新  增  房  源");
            System.out.println("\t\t\t\t\t2 查  找  房  屋");
            System.out.println("\t\t\t\t\t3 删  除  房  屋");
            System.out.println("\t\t\t\t\t4 修  改  房  屋  信  息");
            System.out.println("\t\t\t\t\t5 房  屋  列  表");
            System.out.println("\t\t\t\t\t6 退          出");
            System.out.println("请输入选项（1-6）：");
            key = scanner.nextLine();

            switch (key) {
                case "1":
                    // 显示新增房源方法
                    addHouse();
                    break;
                case "2":
                    // 显示查找房屋界面
                    findHouse();
                    break;
                case "3":
                    // 显示删除房屋界面
                    delHouse();
                    break;
                case "4":
                    // 显示修改房屋信息界面
                    updateHouse();
                    break;
                case "5":
                    // 显示房屋列表界面
                    listHouse();
                    break;
                case "6":
                    // 显示退出界面
                    exit();
                    break;
                default:
                    System.out.println("您的输入有误，请重新输入：");
            }
        }
    }

    public void exit() {
        // 退出界面
        loop = false;
    }

    public void updateHouse() {
        Scanner scanner = new Scanner(System.in);
        // 修改房屋信息
        System.out.println("-----------------修改房屋-----------------");
        System.out.println("请选择你要修改的房屋编号（-1退出）：");
        int id = scanner.nextInt();
        if (id == -1) {
            System.out.println("退出修改房屋选项");
            return;
        }
        // 根据选择的id查找House对象并返回
        House house = houseService.findById(id);
        System.out.print("姓名（" + house.getName() + "）:");
        house.setName(scanner.next());
        System.out.print("电话（" + house.getPhone() + "）:");
        house.setPhone(scanner.next());
        System.out.println("地址（" + house.getAddress() + "）：");
        house.setAddress(scanner.next());
        System.out.print("租金（" + house.getRent() + "）：");
        house.setRent(scanner.nextInt());
        System.out.print("状态（" + house.getState() + "）：");
        house.setState(scanner.next());

        System.out.println("-----------------修改完成-----------------");
    }

    public void delHouse() {
        // 删除房屋信息
    }

    public void addHouse() {
        Scanner scanner = new Scanner(System.in);
        //显示添加房屋界面
        System.out.println("--------------------添加房屋-------------------");
        System.out.println("姓名：");
        String name = scanner.next();
        System.out.println("电话：");
        String address = scanner.next();
        System.out.println("地址：");
        String phone = scanner.next();
        System.out.println("月租：");
        int rent = scanner.nextInt();
        System.out.println("状态（未出租/已出租）：");
        String state = scanner.next();
        // 利用用户输入的数据创建House对象
        House newHouse = new House(0, name, phone, address, rent, state);
        // 添加房屋信息
        if(houseService.add(newHouse)){
            System.out.println("添加房屋成功");
        } else {
            System.out.println("添加房屋失败");
        }
    }

    public void findHouse() {
        // 查找房屋信息
    }

    public void listHouse() {
        // 调用HouseService中的list方法返回所有房屋信息
        House[] houses = houseService.list();
        System.out.println("房屋编号\t\t姓名\t\t\t\t手机号\t\t地址\t\t\t\t房租\t\t\t状态");
        for (House house : houses) {
            System.out.println(house);
        }

    }


}
