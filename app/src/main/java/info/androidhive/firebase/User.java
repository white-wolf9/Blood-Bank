package info.androidhive.firebase;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties

/**
 * Created by SAURAV on 10/2/2017.
 */

public class User {
    public String name;
    public String email;
    public String phone_no;
    public String address;
    public String bloodgroup;
    public String dob;
    public String gender;

    public  User(){

    }

    public User(String name, String email, String phone_no, String address, String bloodgroup, String dob, String gender) {
        this.name = name;
        this.email = email;
        this.phone_no = phone_no;
        this.address = address;
        this.bloodgroup = bloodgroup;
        this.dob = dob;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

}
