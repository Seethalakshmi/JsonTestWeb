package net.yorksolutions.jsontestmodule;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Md5 {
    @JsonProperty
    final String md5;
    @JsonProperty
    final String text;

    public Md5(String md5, String text) {
        this.md5 = md5;
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Md5)) return false;
        Md5 md51 = (Md5) o;
        return Objects.equals(md5, md51.md5) && Objects.equals(text, md51.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(md5, text);
    }
}
