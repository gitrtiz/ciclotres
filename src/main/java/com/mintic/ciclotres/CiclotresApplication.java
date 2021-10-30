package com.mintic.ciclotres;

import com.mintic.ciclotres.service.MotoController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EntityScan(basePackages={"com.mintic.ciclotres"})
@SpringBootApplication
//@ComponentScan(basePackageClasses = MotoController.class)

public class CiclotresApplication {

	public static void main(String[] args) {
		SpringApplication.run(CiclotresApplication.class, args);
	}

}
