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
    public  String primbusiness;
    public String address;
    public String province;
    public String uid;

    public Contact() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    public Contact(String uid, String name, String businessNumber,String primbusiness,String province,String address){
        this.uid = uid;
        this.name = name;
        this.businessNumber = businessNumber;
        this.address = address;
        this.primbusiness = primbusiness;
        this.province = province;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("name", name);
        result.put("business Number", businessNumber);
        result.put("address", address);
        result.put("primary business", primbusiness);
        result.put("province",province);

        return result;
    }
}
