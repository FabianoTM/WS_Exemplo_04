package br.com.ftm.exemplo.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class AlunoWeb {
	
	@WebMethod
	public String ola(String nome){
		return "Ol� " + nome;
	}

}
