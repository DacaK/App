package com.pmfkm.vehicles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass=true)
@SpringBootApplication
public class VehiclesApplication  {

	public static void main(String[] args) {
		SpringApplication.run(VehiclesApplication.class, args);
	}

}
