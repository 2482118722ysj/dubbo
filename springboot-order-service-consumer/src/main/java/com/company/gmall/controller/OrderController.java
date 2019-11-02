package com.company.gmall.controller;

import gmall.bean.UserAddress;
import gmall.service.OrderService;
import gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @ResponseBody
    @GetMapping("/order/{id}")
    public List<UserAddress> initOrder(@PathVariable("id") String userID) {
        System.out.println("userID......."+userID);
        return orderService.initOrder(userID);
    }
}
