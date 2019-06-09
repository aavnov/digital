package com.example.licensecheck.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {

    @JsonProperty("id")
    public String id;

    @JsonProperty("email")
    public String email;

    @JsonProperty("first_name")
    public String first_name;

    @JsonProperty("last_name")
    public String last_name;

    @JsonProperty("avatar")
    public String avatar;
//  даже просто с наличием конструктора конвертатор отказывается работать, беда
/*    public Data(String id, String email, String first_name, String last_name, String avatar) {
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }*/

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
