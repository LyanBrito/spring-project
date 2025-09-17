package com.example.little_luna.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("testa")
public class Controller {
    @GetMapping(value = "1")
    public String oi() {
        return "fala puto";
    }
    @GetMapping(value = "2")
    public String oi2() {
        return "fala puto";
    }
    @GetMapping(value = "3")
    public String oi3() {
        return "fala puto";
    }
    @GetMapping(value = "4")
    public String oi4() {
        return "fala puto";
    }
}
