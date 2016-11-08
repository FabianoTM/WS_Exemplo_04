package br.com.ftm.exemplo.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class AlunoWeb {
	
	private List<Aluno> alunos;
	
	public AlunoWeb(){
		alunos = new ArrayList<>();
	}
	
	@WebMethod
	public String novo(Aluno a){
		alunos.add(a);
		return "Aluno cadasatrado com sucesso!";
	}

	@WebMethod
	public List<Aluno> listar(){
		return alunos;
	}
}
