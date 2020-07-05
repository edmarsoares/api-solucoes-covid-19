package br.com.rede_social.application.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rede_social.domain.model.Usuario;
import br.com.rede_social.domain.service.UsuarioService;
import br.com.rede_social.presentation.dto.request.UsuarioRequestDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "api/usuario", consumes = MediaType.APPLICATION_JSON_VALUE
		+ ";charset=utf-8", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
@Api(value = "api/usuario", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@ApiOperation(httpMethod = "GET", value = "So testando", response = Usuario.class)
	@GetMapping("test")
	public String test() {
		return "Iniciando ...";
	}
	
	@ApiOperation(httpMethod = "POST", value = "Cadastro de usuario", notes = "Endpoint para cadastro de usuarios")
	@PostMapping
	public ResponseEntity<?> cadastrarUsuario(@RequestBody UsuarioRequestDTO request){
		
		Usuario usuario = usuarioService.cadastrarUsuario(request);
		Map<Object, Object> response = new HashMap<Object, Object>();
		response.put("idUsuario", usuario.getId());
		response.put("userName", usuario.getUserName());
		response.put("email", usuario.getEmail());
		response.put("idPessoa", usuario.getPessoa().getId());
		return ResponseEntity.ok(response);
	}
	
	
}
