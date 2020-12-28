package com.example.raspberry.controllers;

import com.pi4j.io.gpio.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by btsioni on 28/12/2020.
 */
@RestController
public class PinController {

    boolean status;

    GpioController controller;
    GpioPinDigitalOutput pin;

    public PinController(){
        controller = GpioFactory.getInstance();
        pin = controller.provisionDigitalOutputPin(RaspiPin.GPIO_01,"MyLed", PinState.LOW);
        status = false;
    }

    @GetMapping("/test")
    public String getTestMessage() {
        return "Test is working";
    }

    @GetMapping("/light")
    public String changeLight() {
        pin.toggle();
        return (status = !status ) ? "ON" : "OFF";
    }

}
