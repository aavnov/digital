package com.example.licensecheck.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Headers {

    @JsonProperty("Accept")
    public String accept;

    @JsonProperty("Date")
    public String date;

    @JsonProperty("Host")
    public String host;

    @JsonProperty("User-Agent")
    public String useragent;

/*    public String getAccept() {
        return accept;
    }

    @JsonProperty("Accept")
    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getHost() {
        return host;
    }

    @JsonProperty("Host")
    public void setHost(String host) {
        this.host = host;
    }

    public String getDate() {
        return date;
    }

    @JsonProperty("Date")
    public void setDate(String date) {
        this.date = date;
    }

    public String getUseragent() {
        return useragent;
    }

    @JsonProperty("User-Agent")
    public void setUseragent(String useragent) {
        this.useragent = useragent;
    }*/
}
