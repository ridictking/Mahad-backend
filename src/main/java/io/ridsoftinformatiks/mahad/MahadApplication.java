package io.ridsoftinformatiks.mahad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;
import java.util.Properties;

@SpringBootApplication
public class MahadApplication {

	public static final Optional<String> host;
	public static final Optional<String> port;
	public  static final Properties myProps = new Properties();

	static{
		host = Optional.ofNullable(System.getenv("HOSTNAME"));
		port = Optional.ofNullable(System.getenv("PORT"));
	}
	public static void main(String[] args) {
		myProps.setProperty("server.address", host.orElse("localhost"));
		myProps.setProperty("server.host", host.orElse("8081"));

		SpringApplication app = new SpringApplication(MahadApplication.class);
		app.setDefaultProperties(myProps);
		app.run(args);
		//SpringApplication.run(MahadApplication.class, args);
	}

}
