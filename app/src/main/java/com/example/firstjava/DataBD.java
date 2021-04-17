package com.example.firstjava;

public class DataBD {
    String day;
    String lesson_name;
    public Integer number_lesson;
    public Integer number_day;

    DataBD(String day, String lesson_name, Integer number_lesson) {
        this.day = day;
        this.lesson_name = lesson_name;
        this.number_lesson = number_lesson;
        switch (day) {
            case "понедельник":
                number_day=0;
                break;
            case "вторник":
                number_day=1;
                break;
            case "среда":
                number_day=2;
                break;
            case "четверг":
                number_day=3;
                break;
            case "пятница":
                number_day=4;
                break;
        }
    }
}
