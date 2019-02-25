package com.sandeep.cache.springredis;

import java.io.Serializable;
import java.util.List;

public class AuthType implements Serializable {

    private List<String> phoneNumbers;

    private String customerNumer;

    private String authId;


    public AuthType(List<String> phoneNumbers, String customerNumer, String authId) {
        this.phoneNumbers = phoneNumbers;
        this.customerNumer = customerNumer;
        this.authId = authId;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getCustomerNumer() {
        return customerNumer;
    }

    public String getAuthId() {
        return authId;
    }
}
