package cn.edu.hcnu.bean;

import java.util.Set;

public class Order {
    private String id;
    private String jpjg;//机票价格
    private float airPortTax;//机场税
    private float ryf;//燃油费
    private float hlzhx;//航空综合险
    private float jpgtx;//机票该退险
    private float yhq;//优惠券
    private float hszj;//含税总价
    private Set<Customer> customer[];

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJpjg() {
        return jpjg;
    }

    public void setJpjg(String jpjg) {
        this.jpjg = jpjg;
    }

    public float getAirPortTax() {
        return airPortTax;
    }

    public void setAirPortTax(float airPortTax) {
        this.airPortTax = airPortTax;
    }

    public float getRyf() {
        return ryf;
    }

    public void setRyf(float ryf) {
        this.ryf = ryf;
    }

    public float getHlzhx() {
        return hlzhx;
    }

    public void setHlzhx(float hlzhx) {
        this.hlzhx = hlzhx;
    }

    public float getJpgtx() {
        return jpgtx;
    }

    public void setJpgtx(float jpgtx) {
        this.jpgtx = jpgtx;
    }

    public float getYhq() {
        return yhq;
    }

    public void setYhq(float yhq) {
        this.yhq = yhq;
    }

    public float getHszj() {
        return hszj;
    }

    public void setHszj(float hszj) {
        this.hszj = hszj;
    }

    public Set<Customer>[] getCustomer() {
        return customer;
    }

    public void setCustomer(Set<Customer>[] customer) {
        this.customer = customer;
    }
}
