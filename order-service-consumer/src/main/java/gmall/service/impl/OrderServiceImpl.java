package gmall.service.impl;

import gmall.bean.UserAddress;
import gmall.service.OrderService;
import gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    UserService userService;
    @Override
    public List<UserAddress> initOrder(String userID) {
        System.out.println("调用"+userID);
        List<UserAddress> userAddressList = userService.getUserAddressList(userID);
        return userAddressList;
    }

}
