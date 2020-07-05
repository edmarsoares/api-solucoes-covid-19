package br.com.rede_social.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rede_social.domain.model.Questionario;
import br.com.rede_social.domain.service.impl.QuestionarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "api/questionario", consumes = MediaType.APPLICATION_JSON_VALUE
		+ ";charset=utf-8", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
@Api(value = "api/questionario", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class QuestionarioController {
	
	@Autowired
	private QuestionarioService questionarioService;
	
	@ApiOperation(httpMethod = "GET", value = "Listar todos os questionários", notes = "Endpoint para listagem de questionário")
	@GetMapping
	public ResponseEntity<?> cadastrarUsuario(Integer id){
		
		List<Questionario> questionarios = questionarioService.listAllByIdPessoa(id);
		return questionarios != null ? ResponseEntity.ok(questionarios) : ResponseEntity.noContent().build();
	}
}
