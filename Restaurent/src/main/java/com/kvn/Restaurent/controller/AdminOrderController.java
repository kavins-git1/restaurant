package com.kvn.Restaurent.controller;

import com.kvn.Restaurent.model.Order;
import com.kvn.Restaurent.model.User;
import com.kvn.Restaurent.request.OrderRequest;
import com.kvn.Restaurent.service.OrderService;
import com.kvn.Restaurent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/admin")
public class AdminOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;


    @GetMapping("/order/restaurant/{id}")
    public ResponseEntity<List<Order>> getOrderHistory(@RequestBody OrderRequest req,
                                                       @PathVariable Long id,
                                                       @RequestParam(required = false) String order_status,
                                                       @RequestHeader("Authorization") String jwt)
            throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        List<Order> orders=orderService.getRestaurantsOrder(id,order_status);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }


    @PutMapping("/order/{id}/{orderStatus}")
    public ResponseEntity<Order> updateOrderStatus(@RequestBody OrderRequest req,
                                                       @PathVariable Long id,
                                                       @PathVariable String orderStatus
                                                      ,
                                                       @RequestHeader("Authorization") String jwt)
            throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        Order orders=orderService.updateOrder(id,orderStatus);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
