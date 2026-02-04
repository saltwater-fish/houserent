package service;

import domain.House;

public class HouseService {
    private House[] houses;
    private int houseNums = 1;
    private int idCounter = 1;

    public HouseService(int size) {
        houses = new House[size];
        houses[0] = new House(1,"jack","112", "海淀区", 2000, "未出租");
    }

    // 添加房屋
    public boolean add(House newHouse) {
        if(houseNums == houses.length) {
            return false;
        }
        houses[houseNums++] = newHouse;
        newHouse.setId(++idCounter);
        return true;
    }
}
