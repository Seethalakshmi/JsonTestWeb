package net.yorksolutions.jsontestmodule;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class DateTime {
    @JsonProperty
     final String date;
    @JsonProperty
     final String time;


    public DateTime(String date, String time) {
        this.date = date;
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DateTime)) return false;
        DateTime dateTime = (DateTime) o;
        return Objects.equals(date, dateTime.date) && Objects.equals(time, dateTime.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, time);
    }
}
