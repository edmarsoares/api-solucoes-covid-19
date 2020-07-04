package br.com.rede_social.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rede_social.domain.model.Pessoa;
import br.com.rede_social.infrastructure.repository.PessoaRepository;

@Service
public class PessoaServiceImpl implements PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Override
	public void save(Pessoa pessoa) {
		this.pessoaRepository.save(pessoa);
	}

	@Override
	public void remove(Integer id) {
		this.pessoaRepository.deleteById(id);
	}

	@Override
	public Optional<Pessoa> findById(Integer id) {
		return pessoaRepository.findById(id);
	}

	@Override
	public List<Pessoa> listAll() {
		return pessoaRepository.findAll();
	}
}
