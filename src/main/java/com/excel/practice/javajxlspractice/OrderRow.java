package com.excel.practice.javajxlspractice;


public class OrderRow {
    private Integer orderId; //訂單序號
    private String type; //商品類型
    private String item; //品項
    private Integer amount; //價格

    public OrderRow(Integer orderId, String type, String item, Integer amount){
        this.setOrderId(orderId);
        this.setType(type);
        this.setItem(item);
        this.setAmount(amount);
    }
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
