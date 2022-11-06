package Delete;

import static org.junit.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RemoverSimulacoes {
	
	@Test
	public void excluirSimulacoes() {
	RequestSpecification request = RestAssured.given();	
	request.header("Content-Type","application/json");
	Response response = request.delete("<host>/api/v1/simulacoes/{1226}");
    System.out.println("Cadastro Excluido com sucesso" + response.asPrettyString());
    int code = 204;
    int CodeRetornado = response.getStatusCode();
	assertEquals(code, CodeRetornado);
		  
		  
   }
	
	@Test
	public void excluirSimulacoesinvalidas() {
	RequestSpecification request = RestAssured.given();	
	request.header("Content-Type","application/json");
	Response response = request.delete("<host>/api/v1/simulacoes/{0000}");
    System.out.println("Simulação não encontrada" + response.asPrettyString());
    int code = 404;
    int CodeRetornado = response.getStatusCode();
	assertEquals(code, CodeRetornado);

}
	
}
