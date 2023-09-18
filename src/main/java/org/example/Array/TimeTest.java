package org.example.Array;

class Time{
    private int hour;
    private int minute;
    private int second;

    public int getHour(){ return hour; };
    public void setHour(int hour){
        if (hour < 0 || hour > 23)return;
        this.hour = hour;

    }
}
public class TimeTest {
    public static void main(String[] args){
        Time t = new Time();
        t.setHour(23); //hour의 값을 23으로 변경
        t.setHour(1000); //1000은 유효한 값이 아니기때문에 값이 변경되지 않는다. 값은 그대로 23
        System.out.println(t.getHour());
    }


}
