package gmall.service;

import gmall.bean.UserAddress;

import java.util.List;

public interface OrderService {

    //根据用户id，初始化订单
    public List<UserAddress> initOrder(String userID);
}
