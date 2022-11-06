package Put;

import static org.junit.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AlterarSimulacao {
	
	@Test
	public void atualizarCadastro() {
    RequestSpecification request = RestAssured.given();   	
	request.header("Content-Type","application/json");
	JSONObject bodyrequest = new JSONObject();
	
	  bodyrequest.put("nome", "Sicredi user");
	  bodyrequest.put("email", "Qa.sicredi.123@gmail.com.br");
	  bodyrequest.put("cpf", "361.120.330-03");
	  bodyrequest.put("valor", " 1.000");
	  bodyrequest.put("parcela", "48");
	  bodyrequest.put("seguro", "True");
	  
      request.body(bodyrequest.toJSONString());
	  
	  Response response = request.put("<host>/api/v1/simulacoes/{361.120.330-03}");
	
	  System.out.println(" Atualização do cadastro é " + response.asPrettyString());
	  
	  int code = 201;
	  int CodeRetornado = response.getStatusCode();
	  assertEquals(code, CodeRetornado);
	  
	  
	}

}

