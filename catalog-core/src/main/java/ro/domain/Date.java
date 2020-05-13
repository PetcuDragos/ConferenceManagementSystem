package ro.domain;

import java.time.LocalDateTime;

public class Date extends BaseEntity {
    private Integer day;
    private Integer month;
    private Integer year;

    public Date() {
        this.day = LocalDateTime.now().getDayOfMonth();
        this.month = LocalDateTime.now().getMonthValue();
        this.year = LocalDateTime.now().getYear();
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }


    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
