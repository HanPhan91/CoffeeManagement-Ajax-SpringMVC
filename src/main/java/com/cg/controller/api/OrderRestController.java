package com.cg.controller.api;

import com.cg.model.CatalogDrink;
import com.cg.model.Drink;
import com.cg.model.Order;
import com.cg.model.OrderDetail;
import com.cg.model.dto.OrderDetailDto;
import com.cg.repository.OrderDetailRepository;
import com.cg.repository.OrderRepository;
import com.cg.service.DrinkService;
import com.cg.service.OrderDetailService;
import com.cg.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderRestController {

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    OrderService orderService;

    @Autowired
    DrinkService drinkService;

    @GetMapping("/{id}")
    public ResponseEntity<?> orderDetail(@PathVariable Long id){
        Order order = orderService.findById(id).get();
        List<OrderDetail> listOrder = orderDetailService.findByOrder(order);
        return new ResponseEntity<>(listOrder, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> doCreate(@RequestBody List<OrderDetailDto> listOrder) {
        Order order = new Order();
        orderService.save(order);
        BigDecimal totalAmount = BigDecimal.valueOf(0);
        for (OrderDetailDto orderDetailDto : listOrder) {
            OrderDetail orderDetail = new OrderDetail();
            Drink drink = drinkService.findById(orderDetailDto.getDrinkId()).get();
            orderDetail.setPriceDrink(drink.getPrice());
            orderDetail.setQuantity(orderDetailDto.getDrinkQuantity());
            BigDecimal total = orderDetailDto.getPrice().multiply(BigDecimal.valueOf(orderDetailDto.getDrinkQuantity()));
            orderDetail.setTotalPrice(total);
            orderDetail.setDrink(drink);
            orderDetail.setOrder(order);

            orderDetailService.save(orderDetail);
            totalAmount = totalAmount.add(total);
        }
        order.setTotalAmount(totalAmount);
        orderService.save(order);
        return new ResponseEntity<>(new Order(), HttpStatus.OK);
    }


}
