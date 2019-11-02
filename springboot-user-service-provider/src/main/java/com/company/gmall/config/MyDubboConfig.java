package com.company.gmall.config;

import com.alibaba.dubbo.config.*;
import gmall.service.UserService;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyDubboConfig {

    //<dubbo:application name="springboot-user-service-provider"></dubbo:application>
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("springboot-user-service-provider");
        return applicationConfig;
    }

    //<dubbo:registry protocol="zookeeper" address="127.0.0.1:2181"></dubbo:registry>
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");
        return registryConfig;
    }

    //<dubbo:protocol name="dubbo" port="20801"></dubbo:protocol>
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20884);
        return protocolConfig;
    }

    /*
    *   <dubbo:service interface="gmall.service.UserService" ref="userServiceImpl" version="1.0.0"  stub="gmall.service.impl.UserServiceImplStub">
        <dubbo:method name="getUserAddressList" timeout="5000"></dubbo:method>
        </dubbo:service>
        <bean id="userServiceImpl" class="com.company.gmall.service.impl.UserServiceImpl"></bean>
    * */
    @Bean
    //在方法的括号中加入你要在容器中配置的接口，在程序启动过得时候会自动把IOC中的实例封装到这里面
    public ServiceConfig<UserService> userServiceConfig(UserService userService) {
        ServiceConfig<UserService> userServiceConfig = new ServiceConfig<>();
        userServiceConfig.setRef(userService);
        userServiceConfig.setVersion("1.0.0");

        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserAddressList");
        methodConfig.setTimeout(2000);
        List<MethodConfig> arraylist = new ArrayList<MethodConfig>();

        userServiceConfig.setMethods(arraylist);

        return userServiceConfig;
    }
    //<dubbo:monitor protocol="registry"></dubbo:monitor>
    @Bean
    public MonitorConfig monitorConfig(){
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol("registry");
        return monitorConfig;
    }
}
