package com.example.raspberry.controllers;

import com.pi4j.io.gpio.*;
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

        //pin = controller.provisionAnalogOutputPin(
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

    @GetMapping("/flash")
    public String flashLight() {
        try {
            for ( int i=0; i< 30 ; i++ ) {
                pin.toggle();
                status = !status;
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if ( status ) {
            pin.toggle();
            status = false;
        }
        return "Done";
    }

}
