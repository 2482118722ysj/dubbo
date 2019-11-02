package gmall;

import gmall.bean.UserAddress;
import gmall.service.UserService;
import gmall.service.impl.OrderServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

public class ConsumerMianApplication {
    public static void main(String[] args) throws IOException, InterruptedException {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("consumer.xml");
        OrderServiceImpl service = ioc.getBean(OrderServiceImpl.class);
        List<UserAddress> userAddresses = service.initOrder("1");
        for(UserAddress userAddress:userAddresses){
            System.out.println(userAddress.getUserAddress());
        }
        System.in.read();
    }
}
