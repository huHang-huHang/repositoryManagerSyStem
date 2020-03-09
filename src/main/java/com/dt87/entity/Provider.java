package com.dt87.entity;

import java.io.Serializable;

public class Provider implements Serializable {
/**
 * @description:
 * @author: Mr.HuHang
 * @create: 2020-03-01 15:20
 **/
private Integer id;

    private String providername;

    private String zip;

    private String address;

    private String telephone;

    private String connectionperson;

    private String phone;

    private String bank;

    private String account;

    private String email;

    private String fax;

    private Integer available;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvidername() {
        return providername;
    }

    public void setProvidername(String providername) {
        this.providername = providername;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getConnectionperson() {
        return connectionperson;
    }

    public void setConnectionperson(String connectionperson) {
        this.connectionperson = connectionperson;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "id=" + id +
                ", providername='" + providername + '\'' +
                ", zip='" + zip + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", connectionperson='" + connectionperson + '\'' +
                ", phone='" + phone + '\'' +
                ", bank='" + bank + '\'' +
                ", account='" + account + '\'' +
                ", email='" + email + '\'' +
                ", fax='" + fax + '\'' +
                ", available=" + available +
                '}';
    }
}
