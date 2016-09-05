package convert;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import convert.wsdl.CelsiusToFahrenheit;
import convert.wsdl.CelsiusToFahrenheitResponse;

public class ConvertClient extends WebServiceGatewaySupport {

	public CelsiusToFahrenheitResponse convertCelsiusToFarenheit(CelsiusToFahrenheit request) {
		SoapActionCallback soapActionCallback = new SoapActionCallback("http://www.w3schools.com/xml/CelsiusToFahrenheit");
		String urlWebService = "http://www.w3schools.com/xml/tempconvert.asmx";
		CelsiusToFahrenheitResponse celsiusToFahrenheitResponse = (CelsiusToFahrenheitResponse) getWebServiceTemplate()
				.marshalSendAndReceive(urlWebService, request,
						soapActionCallback);
		return celsiusToFahrenheitResponse;
	}
}
