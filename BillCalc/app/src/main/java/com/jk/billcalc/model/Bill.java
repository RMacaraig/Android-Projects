package com.jk.billcalc.model;

/**
 * Created by 991435278: Ryle Cheyene Macaraig
 * on 2019-06-19.
 */

//model
public class Bill {

    String accountNumber, name;
    Integer weekday, evening, video;
    Float total;

    public Bill(String accountNumber, String name, Integer weekday, Integer evening, Integer video, Float total) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.weekday = weekday;
        this.evening = evening;
        this.video = video;
        this.total = total;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public Integer getWeekday() {
        return weekday;
    }

    public Integer getEvening() {
        return evening;
    }

    public Integer getVideo() {
        return video;
    }

    public Float getTotal() {
        return total;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
    }

    public void setEvening(Integer evening) {
        this.evening = evening;
    }

    public void setVideo(Integer video) {
        this.video = video;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", weekday=" + weekday +
                ", evening=" + evening +
                ", video=" + video +
                ", total=" + total +
                '}';
    }
}
