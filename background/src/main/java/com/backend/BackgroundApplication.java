package com.backend;

import com.backend.logic.LoginTestLogic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackgroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackgroundApplication.class, args);

		LoginTestLogic.run("ABCD-213AB-GH7");
	}

}
