package gmall.service.impl;

import gmall.bean.UserAddress;
import gmall.service.UserService;

import java.util.List;

public class UserServiceImplStub implements UserService {
    private final UserService userService;
   /*
   * 将远程的接口代理注入(dubbo自动注入）*/
    public UserServiceImplStub(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("UserServiceImplStub...start....");
        if (userId!=null){
            List<UserAddress> userAddressList = userService.getUserAddressList(userId);
            return userAddressList;
        }
        return null;
    }
}
