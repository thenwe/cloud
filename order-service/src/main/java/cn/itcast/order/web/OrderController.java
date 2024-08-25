package cn.itcast.order.web;

import cn.itcast.feign.User.User;
import cn.itcast.feign.clients.UserClient;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    /*   @Autowired
       private RestTemplate restTemplate;*/
    @Autowired
    private UserClient userClient;

    @GetMapping("{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId,
                                    @RequestHeader(value = "Truth", required = false) String truth) {
        System.out.println("---->" + truth);
        // 根据id查询订单并返回
        Order order = orderService.queryOrderById(orderId);
        /*String url="http://userservice/user/"+order.getId();
        User user=restTemplate.getForObject(url, User.class);
        order.setUser(user);*/
        User user = userClient.findById(order.getId());//用feign进行远程调用
        order.setUser(user);
        return order;
    }

}
