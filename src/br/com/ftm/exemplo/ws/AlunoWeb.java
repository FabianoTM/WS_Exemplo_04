package br.com.ftm.exemplo.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService
public class AlunoWeb {
	
	@Resource
    WebServiceContext wsctx;
	
	private List<Aluno> alunos;
	
	public AlunoWeb(){
		alunos = new ArrayList<>();
	}
	
	@WebMethod
	public String novo(Aluno a){
		if(autenticado()){
			alunos.add(a);
			return "Aluno cadasatrado com sucesso!";
		}else{
			return "Falha na autenticação";
		}
	}

	@WebMethod
	public List<Aluno> listar() throws Exception{
		if(autenticado()){
			return alunos;
		}else{
			throw new Exception("Erro de autenticação");
		}
	}
	
	public boolean autenticado(){
		MessageContext mctx = wsctx.getMessageContext();
		
		Map http_header	= (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
		List usuarios 	= (List) http_header.get("Username");
		List senhas 	= (List) http_header.get("Password");
		
		String usuario 	= "";
		String senha 	= "";
		
		if(usuarios != null){
			usuario = usuarios.get(0).toString();
		}
		if(senhas != null){
			senha = senhas.get(0).toString();
		}
		
		//Aplicar a regra de validação do usuario
		//Neste exemplo usuario e senha é 'admin'
		if(usuario.equals("admin") && senha.equals("admin")){
			return true;
		}else{
			return false;
		}
	}
}
