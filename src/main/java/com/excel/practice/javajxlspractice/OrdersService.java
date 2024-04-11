package com.excel.practice.javajxlspractice;

import jakarta.servlet.http.HttpServletResponse;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrdersService {
    private String customer = "阿紫";
    private List<OrderRow> foodOrderList;
    private List<OrderRow> toyOrderList;

    public void exportOrder(HttpServletResponse response) {
//        this.createOrderItems();

        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream("templates/orderlist.xlsx")) {
            //設置檔頭資訊 編碼
            String fileName = URLEncoder.encode("測試表", "UTF-8");

            response.setHeader("Content-Disposition", "attachment; filename=" +
                    new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + ".xlsx");
            response.setContentType("application/vnd.ms-excel;charset=utf8");

            OutputStream os = response.getOutputStream();
            Context context = new Context();
            context.putVar("customer", this.customer);
            context.putVar("foods", this.foodOrderList);
            context.putVar("toys", this.toyOrderList);
            System.out.println("Context:" + context);
            JxlsHelper.getInstance().setEvaluateFormulas(true).processTemplate(is, os, context);
            os.flush();
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createOrderItems() {
        this.foodOrderList = new ArrayList<>();
        for(Integer i = 1; i <= 15; i++){
            OrderRow orderRow = new OrderRow(i, "food", "food" + i.toString(), i*10);
            this.foodOrderList.add(orderRow);
        }

        this.toyOrderList = new ArrayList<>();
        for(Integer i = 1; i <= 10; i++){
            OrderRow orderRow = new OrderRow(i, "toy", "toy" + i.toString(), i*100);
            this.toyOrderList.add(orderRow);
        }
    }
}
