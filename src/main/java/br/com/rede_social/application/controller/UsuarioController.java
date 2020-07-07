package br.com.rede_social.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

import br.com.rede_social.domain.model.Usuario;
import br.com.rede_social.domain.service.UsuarioService;
import br.com.rede_social.presentation.dto.request.UsuarioRequestDTO;
import br.com.rede_social.presentation.dto.request.UsuarioRequestSearch;
import br.com.rede_social.presentation.dto.response.UsuarioResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/usuario")
@Api(value = "/api/usuario", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, tags = "Usuario", description = "Endpoint para cadastro de usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@ApiOperation(httpMethod = "POST", value = "Cadastro de usuario", notes = "Endpoint para cadastro de usuarios", response = UsuarioResponseDTO.class)
	@PostMapping
	public ResponseEntity<?> cadastrarUsuario(@RequestBody UsuarioRequestDTO request) {
		Usuario usuario = usuarioService.cadastrarUsuario(request);
		UsuarioResponseDTO userResponse = usuario.toResponseDTO();
		return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
	}

	@ApiOperation(httpMethod = "GET", value = "Buscar usuário", notes = "Endpoint para recuperar um usuário", response = UsuarioResponseDTO.class)
	@RequestMapping(method = RequestMethod.GET, value = "/{id}", path = "/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id) throws Exception {
		try {
			Usuario usuario = usuarioService.buscar(id);
			UsuarioResponseDTO userResponse = usuario.toResponseDTO();
			return ResponseEntity.status(HttpStatus.OK).body(userResponse);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@ApiOperation(httpMethod = "GET", value = "Listar usuáruis", notes = "Endpoint para listar os usuários", response = UsuarioResponseDTO.class)
	@GetMapping
	public ResponseEntity<?> listar(UsuarioRequestSearch usuario) throws Exception {
		List<Usuario> users = usuarioService.listar(usuario);
		List<UsuarioResponseDTO> response = Lists.newArrayList();
		users.forEach(user -> response.add(user.toResponseDTO()));
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
