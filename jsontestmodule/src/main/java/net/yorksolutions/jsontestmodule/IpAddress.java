package net.yorksolutions.jsontestmodule;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


public class IpAddress {
    @JsonProperty
    final String ip;

    public IpAddress(String ip) {
        this.ip = ip;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IpAddress)) return false;
        IpAddress ipAddress = (IpAddress) o;
        return Objects.equals(ip, ipAddress.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip);
    }
}
