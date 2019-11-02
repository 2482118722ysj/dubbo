package com.company.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import gmall.bean.UserAddress;
import gmall.service.OrderService;
import gmall.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {
    @Reference//远程调用service
    UserService userService;
    @Override
    @HystrixCommand(fallbackMethod = "initOrder2")
    public List<UserAddress> initOrder(String userID) {
        System.out.println("调用"+userID);
        List<UserAddress> userAddressList = userService.getUserAddressList(userID);
        return userAddressList;
    }
    public List<UserAddress> initOrder2(String userID) {
        return Arrays.asList(new UserAddress(1,"老子在中南海","001","不服来干我","15245124512","就看你敢不敢"));
    }

}
