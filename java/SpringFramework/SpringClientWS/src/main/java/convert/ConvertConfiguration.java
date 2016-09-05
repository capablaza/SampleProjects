package convert;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ConvertConfiguration {
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("convert.wsdl");
		return marshaller;
	}

	@Bean
	public ConvertClient weatherClient(Jaxb2Marshaller marshaller) {
		ConvertClient client = new ConvertClient();
		client.setDefaultUri("http://www.w3schools.com/xml/tempconvert.asmx");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
