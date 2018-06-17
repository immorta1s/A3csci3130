package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

public class Contact implements Serializable {

    public  String businessNumber;
    public  String name;
    public  String primBusiness;
    public String address;
    public String province;
    public String uid;

    public Contact() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    public Contact(String uid, String name, String businessNumber,String primBusiness,String province,String address){
        this.uid = uid;
        this.name = name;
        this.businessNumber = businessNumber;
        this.address = address;
        this.primBusiness = primBusiness;
        this.province = province;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("name", name);
        result.put("businessNumber", businessNumber);
        result.put("address", address);
        result.put("primBusiness", primBusiness);
        result.put("province",province);

        return result;
    }
}
