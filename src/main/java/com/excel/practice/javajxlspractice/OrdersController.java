package com.excel.practice.javajxlspractice;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excel.practice.javajxlspractice.OrdersService;
@RestController
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping("/")
    public String exportOrder(HttpServletResponse response){
        ordersService.exportOrder(response);
        return "訂單明細產出完成~";
    }
}
