package net.yorksolutions.jsontestmodule;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class JsonValidateResponse {
@JsonProperty("validate")
public final boolean isValid;
    public JsonValidateResponse(boolean isValid) {
        this.isValid = isValid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JsonValidateResponse)) return false;
        JsonValidateResponse that = (JsonValidateResponse) o;
        return isValid == that.isValid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isValid);
    }
}
