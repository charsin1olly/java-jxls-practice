package com.excel.practice.javajxlspractice;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrdersService {
    private List<OrderRow> foodOrderList;
    private List<OrderRow> toyOrderList;

    public void exportOrder() {
        this.createOrderItems();

    }

    private void createOrderItems() {
        this.foodOrderList = new ArrayList<>();
        for(Integer i = 1; i < 5; i++){
            OrderRow orderRow = new OrderRow(i, "food", "food" + i.toString(), i*10);
            foodOrderList.add(orderRow);
        }

        this.toyOrderList = new ArrayList<>();
        for(Integer i = 1; i < 10; i++){
            OrderRow orderRow = new OrderRow(i, "toy", "toy" + i.toString(), i*100);
            foodOrderList.add(orderRow);
        }

        System.out.println("目前有的food內容：" + this.foodOrderList);
        System.out.println("目前有的toy內容：" + this.foodOrderList);
    }
}
