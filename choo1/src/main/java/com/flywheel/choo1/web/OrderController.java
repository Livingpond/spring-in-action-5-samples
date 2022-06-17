package com.flywheel.choo1.web;

import com.flywheel.choo1.Order;
import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author yekw
 * @date 2022/6/17/11:22
 * @description:
 */
@Slf4j
@RequestMapping("/orders")
@Controller
public class OrderController {
    @GetMapping("/current")
    public String orderForm(Model model){
        log.info("current ");
        model.addAttribute("order",new Order());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors){
        if(errors.hasErrors()){
            return "design";
        }
        log.info("order submitted: " + order);
        return "redirect:/";
    }
}
