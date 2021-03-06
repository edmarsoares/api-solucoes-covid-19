package br.com.rede_social.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rede_social.domain.model.Questionario;
import br.com.rede_social.domain.service.impl.QuestionarioService;
import br.com.rede_social.presentation.dto.request.QuestionarioRequestDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "api/questionario")
@Api(value = "api/questionario", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class QuestionarioController {
	
	@Autowired
	private QuestionarioService questionarioService;
	
	@ApiOperation(httpMethod = "GET", value = "Listar todos os questionários", notes = "Endpoint para listagem de questionário")
	@GetMapping("/{id}")
	public ResponseEntity<?> listAllByIdPessoa(@PathVariable("id") Integer id){
		List<Questionario> questionarios = questionarioService.listAllByIdPessoa(id);
		return ResponseEntity.ok(questionarios);
	}
	
	@ApiOperation(httpMethod = "POST", value = "Cadastrar um questionario", notes = "Endpoint para cadastro de questionário")
	@PostMapping
	public ResponseEntity<?> cadastrarQuestionario(@RequestBody QuestionarioRequestDTO questionarioDto){
		questionarioService.cadastrarQuestionario(questionarioDto);
		return ResponseEntity.ok().build();
	}
}
