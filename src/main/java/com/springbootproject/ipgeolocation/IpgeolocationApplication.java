package com.springbootproject.ipgeolocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// import java.io.IOException;
// import com.springbootproject.ipgeolocation.service.LocationService;

@SpringBootApplication
public class IpgeolocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpgeolocationApplication.class, args);
	}

	// public static void main(String[] args) throws IOException {
	// 	System.out.println(LocationService.GenerateUrl().getString("url"));
	// }

}
