package com.example.licensecheck.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListUsers {

        @JsonProperty("page")
        public String page;

        @JsonProperty("per_page")
        public String per_page;

        @JsonProperty("total")
        public String total;

        @JsonProperty("total_pages")
        public String total_pages;

        @JsonProperty("data")
        public Data[] data;
}

