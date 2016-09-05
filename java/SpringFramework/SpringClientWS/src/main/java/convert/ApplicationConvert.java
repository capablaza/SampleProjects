package convert;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import convert.wsdl.CelsiusToFahrenheit;
import convert.wsdl.CelsiusToFahrenheitResponse;

@SpringBootApplication
public class ApplicationConvert {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationConvert.class);
	}

	@Bean
	CommandLineRunner lookup(ConvertClient convertClient) {

		return args -> {
			CelsiusToFahrenheit request = new CelsiusToFahrenheit();
			request.setCelsius("12");
			CelsiusToFahrenheitResponse response = convertClient.convertCelsiusToFarenheit(request);
			System.out.println(response.getCelsiusToFahrenheitResult());
		};

	}
}
