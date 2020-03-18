package cn.pzh.hl.invoke.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
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
@RequestMapping("invoke")
@DefaultProperties(defaultFallback = "globalFallBack")
@Slf4j
public class InvokeController {
    //自动注入是  bean对象 的引用，还是一个新的bean对象 ？？？
    //是不是说
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

     RibbonLoadBalanceClient（）
//    @Autowired
//    private RibbonLoadBalancerClient ribbonLoadBalancerClient;

//    @GetMapping("/{id}")//hl 注解除了用在方法、类上，还可以用在方法的形参上
//    public User getUser(@PathVariable("id")Long id){
//        //hl 只写后面部分不  写变量的声明   alt+enter-->introduce local variable :引入局部变量
//        User user = restTemplate.getForObject("http://localhost:8081/user/" + id, User.class);
//        //hl log.info只能打印String 不能直接打印对象 ---》所以调用对象 的toString方法
//        log.info(user.toString());
//        return  user;
//    }

//    /**
//     * 通过获取  服务实例 来调用服务
//     * @param id
//     * @return
//             */
//    @GetMapping("/{id}")
//    @HystrixCommand(fallbackMethod ="getUserFailback")
//    public User getUser(@PathVariable("id")Long id){
//        //使用 Eureka 让 获取 服务的  url更加简单。减少了url的死编码
//        //获取 到 服务提供者的  url后，还是要通过 客户端工具来实现 服务间的调用
//
//
//        //用来代替
////        List<ServiceInstance> instances = discoveryClient.getInstances("user-manage-service");
////        ServiceInstance serviceInstance = instances.get(0);
//        //ribbon 封装了 根据 负载均衡算法 来 获取 服务实例 的代码
////        ServiceInstance serviceInstance = ribbonLoadBalancerClient.choose("user-manage-service");
////
////        String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/"+id;
//
//        String url = "http://user-manage-service/user/"+id;
//        User user = restTemplate.getForObject(url, User.class);
//        System.out.println("无敌！");
//        return  user;
//    }

    /**
     * 有降级逻辑处理的法的  方法--》返回值，统一为String类型，就算返回的是一个对象 ，也返回 这个对象 的json 字符串
     * 这样方便  后面的处理，简化自己的操作
     *
     * 没有降级逻辑处理的方法的  方法，该返回什么类型的数据就返回什么类型的数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    //@HystrixCommand(fallbackMethod = "getUserFailback",commandProperties =  @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000"))
    @HystrixCommand(fallbackMethod = "getUserFailback")
    public String getUser(@PathVariable("id")Long id){
        String url = "http://user-manage-service/user/"+id;
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String user = restTemplate.getForObject(url, String.class);
        System.out.println("InvokerController-id向服务提供方请求了！");
        return  user;
    }

    @GetMapping("/hello")
    @HystrixCommand
    public String getUser(){
        String url = "http://user-manage-service/user/"+2;
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String user = restTemplate.getForObject(url, String.class);
        System.out.println("InvokerController-hello向服务提供方请求了！");
        return  user;
    }

//方法参数 不用再加上  @PathVariable
    public String getUserFailback(Long id){
        return "请求忙，请稍后再试！";
    }

    public String globalFallBack(){
        return "这是全局熔断方法";
    }
}
