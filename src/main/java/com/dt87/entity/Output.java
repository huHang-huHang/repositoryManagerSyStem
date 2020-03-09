package com.dt87.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Output implements Serializable {
/**
 * @description:
 * @author: Mr.HuHang
 * @create: 2020-03-02 09:59
 **/
private Integer id;

    private Integer providerid;

    private String paytype;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date outporttime;

    private String operateperson;

    private Double outportprice;

    private Integer number;

    private String remark;

    private Integer goodsid;

    private Integer inportid;


    private String providername;
    private String goodsname;
    private String size;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProviderid() {
        return providerid;
    }

    public void setProviderid(Integer providerid) {
        this.providerid = providerid;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public Date getOutporttime() {
        return outporttime;
    }

    public void setOutporttime(Date outporttime) {
        this.outporttime = outporttime;
    }

    public String getOperateperson() {
        return operateperson;
    }

    public void setOperateperson(String operateperson) {
        this.operateperson = operateperson;
    }

    public Double getOutportprice() {
        return outportprice;
    }

    public void setOutportprice(Double outportprice) {
        this.outportprice = outportprice;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getInportid() {
        return inportid;
    }

    public void setInportid(Integer inportid) {
        this.inportid = inportid;
    }

    public String getProvidername() {
        return providername;
    }

    public void setProvidername(String providername) {
        this.providername = providername;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Output{" +
                "id=" + id +
                ", providerid=" + providerid +
                ", paytype='" + paytype + '\'' +
                ", outporttime=" + outporttime +
                ", operateperson='" + operateperson + '\'' +
                ", outportprice=" + outportprice +
                ", number=" + number +
                ", remark='" + remark + '\'' +
                ", goodsid=" + goodsid +
                ", inportid=" + inportid +
                ", providername='" + providername + '\'' +
                ", goodsname='" + goodsname + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
