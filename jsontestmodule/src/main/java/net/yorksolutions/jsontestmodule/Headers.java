package net.yorksolutions.jsontestmodule;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Headers {
    @JsonProperty
    final String secFetchMode;
    @JsonProperty
    final String secFetchSite;
    @JsonProperty
    final String acceptLanguage;
    @JsonProperty
    final String cookie;
    @JsonProperty
    final String purpose;
    @JsonProperty
    final String secFetchUser;
    @JsonProperty
    final String accept;
    @JsonProperty
    final String secChUa;
    @JsonProperty
    final String secChUaMobile;
    @JsonProperty
    final String secChUaPlatform;
    @JsonProperty
    final String host;
    @JsonProperty
    final String upgradeInsecureRequests;
    @JsonProperty
    final String connection;
    @JsonProperty
    final String acceptEncoding;
    @JsonProperty
    final String userAgent;
    @JsonProperty
    final String secFetchDest;

    public Headers(String secFetchMode, String secFetchSite, String acceptLanguage, String cookie, String purpose, String secFetchUser, String accept, String secChUa, String secChUaMobile, String secChUaPlatform, String host, String upgradeInsecureRequests, String connection, String acceptEncoding, String userAgent, String secFetchDest) {
        this.secFetchMode = secFetchMode;
        this.secFetchSite = secFetchSite;
        this.acceptLanguage = acceptLanguage;
        this.cookie = cookie;
        this.purpose = purpose;
        this.secFetchUser = secFetchUser;
        this.accept = accept;
        this.secChUa = secChUa;
        this.secChUaMobile = secChUaMobile;
        this.secChUaPlatform = secChUaPlatform;
        this.host = host;
        this.upgradeInsecureRequests = upgradeInsecureRequests;
        this.connection = connection;
        this.acceptEncoding = acceptEncoding;
        this.userAgent = userAgent;
        this.secFetchDest = secFetchDest;
    }

    public String getSecFetchMode() {
        return secFetchMode;
    }

    public String getSecFetchSite() {
        return secFetchSite;
    }

    public String getAcceptLanguage() {
        return acceptLanguage;
    }

    public String getCookie() {
        return cookie;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getSecFetchUser() {
        return secFetchUser;
    }

    public String getAccept() {
        return accept;
    }

    public String getSecChUa() {
        return secChUa;
    }

    public String getSecChUaMobile() {
        return secChUaMobile;
    }

    public String getSecChUaPlatform() {
        return secChUaPlatform;
    }

    public String getHost() {
        return host;
    }

    public String getUpgradeInsecureRequests() {
        return upgradeInsecureRequests;
    }

    public String getConnection() {
        return connection;
    }

    public String getAcceptEncoding() {
        return acceptEncoding;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getSecFetchDest() {
        return secFetchDest;
    }

}
