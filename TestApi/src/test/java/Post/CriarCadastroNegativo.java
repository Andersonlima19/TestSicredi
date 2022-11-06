package Post;

import static org.junit.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CriarCadastroNegativo {
	
	@Test
	public void criarCadastro() {
    RequestSpecification request = RestAssured.given();   	
	request.header("Content-Type","application/json");
	JSONObject bodyrequest = new JSONObject();
	
	  bodyrequest.put("nome", "Sicredi user");
	  bodyrequest.put("email", "Qa.sicredi@gmail.com.br");
	  bodyrequest.put("cpf", "1111111");
	  bodyrequest.put("valor", " 1.000");
	  bodyrequest.put("parcela", "48");
	  bodyrequest.put("seguro", "True");
	  
      request.body(bodyrequest.toJSONString());
	  
	  Response response = request.post("<host>/api/v1/simulacoes");
	
	  System.out.println("O Retorno do cadastro é " + response.asPrettyString());
	  
	  int code = 400;
	  int CodeRetornado = response.getStatusCode();
	  assertEquals(code, CodeRetornado);
	  
	  
	}

}
