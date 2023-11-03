package com.example.carrace;

import java.util.List;

public class CarGroup {
    private final List<Car> carList;
    private int maxScore =0;

    CarGroup(List<Car> carList){

        this.carList = carList;
    }

    public int countCar(){
        return carList.size();
    }

    public int getMaxScore(){
        for (Car car:carList){
            int i = car.getScore();
            if(maxScore<i) maxScore=i;
        }
        return maxScore;
    }

    public int countWinCar(){
        for(Car car:carList){
            if(car.getScore().equals(maxScore)){

            }
        }
    }


}
