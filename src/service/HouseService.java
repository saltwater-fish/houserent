package service;

import domain.House;

public class HouseService {
    private House[] houses;
    private int houseNums = 2;
    private int idCounter = 2;

    public HouseService(int size) {
        houses = new House[size];
        houses[0] = new House(1,"jack","112", "海淀区", 2000, "未出租");
        houses[1] = new House(2,"jack2","112", "海淀区", 2000, "未出租");
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

    public House[] list() {
        return houses;
    }

    public House findById(int id) {
        for (House house : houses) {
            if (id == house.getId()) {
                return house;
            }
        }
        return null;
    }

    public boolean delById(int id) {
        int index = -1;
        for (int i = 0; i < houseNums; i++) {
            if (id == houses[i].getId()) {
                index = i;
            }
        }
        if (index == -1){
            return false;
        }
        for(int i = index; i < houseNums - 1; i++) {
            houses[i] = houses[i+1];
        }
        //把当有存在的房屋信息的最后一个 设置null
        houses[--houseNums] = null;
        return true;
    }
}
