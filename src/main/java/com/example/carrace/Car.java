package com.example.carrace;

public class Car {
    //필드
    String carName;
    int score;
    boolean win;
    private final int randomNum = 4;

    //생성자
    Car(String carName){
        if(carName.length()>5)throw new IllegalArgumentException("차 이름은 5자 이하로 설정해주세요.");
        carName = carName.replaceAll(" ","");
        this.carName = carName;
        this.score = 0;
        this.win = false;
    }

    public Integer getScore() {
        return score;
    }

    private void addScore(){
        int score = getScore();
        this.score = score++;
    }

    private void drive(){
        double r = Math.random();
        int t = Math.toIntExact(Math.round(r * 10));
        int s = getScore();
        if(t>=randomNum) addScore();
    }

    public boolean isWin(){
        return win;
    }
}
