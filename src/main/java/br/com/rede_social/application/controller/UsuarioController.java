package br.com.rede_social.application.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rede_social.domain.model.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "api/usuario", consumes = MediaType.APPLICATION_JSON_VALUE
		+ ";charset=utf-8", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
@Api(value = "api/usuario", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {
	
	@ApiOperation(httpMethod = "POST", value = "So testando", response = Usuario.class)
	@GetMapping("test")
	public String test() {
		return "Iniciando ...";
	}
}
