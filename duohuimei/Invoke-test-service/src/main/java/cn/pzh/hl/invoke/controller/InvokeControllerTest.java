package cn.pzh.hl.invoke.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
@RequestMapping("invokeTest")
@Slf4j
public class InvokeControllerTest {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/{id}")
    @HystrixCommand(fallbackMethod = "getUserFailback")
    public String getUser(@PathVariable("id")Long id){
        String url = "http://user-manage-service/user/"+id;
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String user = restTemplate.getForObject(url, String.class);
        System.out.println("InvokerControllerTest向服务提供方请求了！");
        return  user;
    }
}
