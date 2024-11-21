package com.KAYAN.KayanWeb.controller;

import com.KAYAN.KayanWeb.model.CustomerDto;
import com.KAYAN.KayanWeb.service.CustomerService;
import com.KAYAN.KayanWeb.service.CustomerServiceInt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/homepage")
public class CustomerController {
    public final CustomerServiceInt customerServiceInt;
    public CustomerController(CustomerServiceInt customerServiceInt) {
        this.customerServiceInt = customerServiceInt;
    }
    //home page
    @GetMapping
    public String homepage(Model model) {
        return "index";
    }

    //login method
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("customerDto" , new CustomerDto());
        return "login";
    }
    @PostMapping
    public String loginSubmit(@ModelAttribute("customerDto") CustomerDto customerDto) {
        customerServiceInt.addCustomer(customerDto);
        return "service";
    }

    //forget password?
    @GetMapping("/forget")
    public String forgetPassword(Model model) {
        model.addAttribute("customerDto" , new CustomerDto());
        return "forgetPassword";
    }
    @PatchMapping
    public String updatePassword(@ModelAttribute("customerDto") CustomerDto customerDto) {
        customerServiceInt.patchUpdateCustomer(customerDto , customerDto.getId());
        return "login";
    }

    //signup
    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("customerDto" , new CustomerDto());
        return "signup";
    }
    @PostMapping
    public String signupSubmit(@ModelAttribute("customerDto") CustomerDto customerDto) {
        customerServiceInt.addCustomer(customerDto);
        return "login";
    }
}
