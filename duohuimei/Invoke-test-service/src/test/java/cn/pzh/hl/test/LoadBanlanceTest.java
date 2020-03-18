package cn.pzh.hl.test;

import cn.pzh.hl.invoke.InvokeApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = InvokeApplication.class)
public class LoadBanlanceTest {
    @Autowired
    private RibbonLoadBalancerClient ribbonLoadBalancerClient;

    @Test
    public void showServiceIdd(){
        for (int i = 0;i < 10;++i){
            ServiceInstance serviceInstance = ribbonLoadBalancerClient.choose("user-manage-service");
            System.out.println("主机名："+serviceInstance.getHost()+",端口号："+serviceInstance.getPort());
        }
    }
}
