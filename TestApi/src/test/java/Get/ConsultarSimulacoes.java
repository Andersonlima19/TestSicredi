package Get;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ConsultarSimulacoes {

	@Test
	public void consultarSimulacoes() {
    RequestSpecification request = RestAssured.given();
	request.header("Content-Type", "application/json");
	Response response = request.get("<host>/api/v1/restricoes/{99999999999}");
	int statusCode = response.getStatusCode();
	String bodyrequest = response.asString();
	System.out.println(bodyrequest);
	String name = "O CPF 99999999999 possui restrição";
	assertTrue(bodyrequest.contains(name));
	assertEquals(200, statusCode);

	}

}
