package com.example.licensecheck.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Inet {
    @JsonProperty("args")
    public Args args;


    @JsonProperty("headers")
    public Headers headers;

    @JsonProperty("origin")
    public String origin;

    @JsonProperty("url")
    public String url;




/*    public Args getArgs() {
        return args;
    }

    public void setArgs(Args args) {
        this.args = args;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }*/
}
