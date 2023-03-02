package org.ajac.services;

import io.vavr.collection.List;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public enum ClassDay {
    MONDAY(1, "07:30 PM"),
    TUESDAY(2, "07:30 PM"),
    WEDNESDAY(3, "07:30 PM"),
    THURSDAY(4, "07:30 PM"),
    FRIDAY(5, "07:30 PM"),
    SATURDAY(6, "08:15 AM"),
    UNKNOWN(-1, "");

    private final int code;
    private final String time;

    ClassDay(int code, String time) {
        this.code = code;
        this.time = time;
    }

    public int getCode() {
        return code;
    }

    public String getTime() {
        return time;
    }

    public static ClassDay get(int day) {
        return List.of(ClassDay.values())
          .find(classDay -> classDay.code == day)
          .getOrElse(UNKNOWN);
    }

    public static boolean isClassDayValid(ClassDay classDay) {
        return !classDay.equals(UNKNOWN);
    }
}
