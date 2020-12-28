package com.example.raspberry;

import com.pi4j.io.gpio.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RaspberryApplication {

	public static void main(String[] args) {
		SpringApplication.run(RaspberryApplication.class, args);
		System.out.println("Hello world");



		/*try {
			for ( int i=0; i<30; i++) {
				pin.toggle();
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}
}
