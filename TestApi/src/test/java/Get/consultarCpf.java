package Get;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class consultarCpf {

	@Test
	public void consultarSimulacoes() {
    RequestSpecification request = RestAssured.given();
	request.header("Content-Type", "application/json");
	Response response = request.get("<host>/api/v1/restricoes/{361.120.330-03}");
	int statusCode = response.getStatusCode();
	String bodyrequest = response.asString();
	System.out.println(bodyrequest);
	String name = "361.120.330-03";
	assertTrue(bodyrequest.contains(name));
	assertEquals(200, statusCode);
	

	}
	
	@Test
	public void consultarSimulacoesNegativa() {
    RequestSpecification request = RestAssured.given();
	request.header("Content-Type", "application/json");
	Response response = request.get("<host>/api/v1/restricoes/{111.111.111-11}");
	int statusCode = response.getStatusCode();
	String bodyrequest = response.asString();
	System.out.println(bodyrequest);
	String name = "111.111.111-11";
	assertTrue(bodyrequest.contains(name));
	assertEquals(404, statusCode);
	

	}

}
