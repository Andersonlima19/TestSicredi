package Get;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ConsultarRestricoes {

	@Test
	public void consultarRestricoes() {
	RequestSpecification request = RestAssured.given();
	request.header("Content-Type", "application/json");
	Response response = request.get("<host>/api/v1/simulacoes");
	int statusCode = response.getStatusCode();
    assertEquals(200, statusCode);
	
  }
	
	@Test
	public void consultarRestricoesNegativas() {
	RequestSpecification request = RestAssured.given();
	request.header("Content-Type", "application/json");
	Response response = request.get("<host>/api/v1/simulacoes");
	int statusCode = response.getStatusCode();
    assertEquals(204, statusCode);

}
	
}
	

