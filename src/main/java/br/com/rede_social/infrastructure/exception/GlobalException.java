package br.com.rede_social.infrastructure.exception;

import java.util.List;

import org.springframework.http.HttpStatus;

/*
* @author Jair Anderson <jair_anderson_bs@hotmail.com>
* @since 9 de jun de 2020
*/

public class GlobalException {

    private HttpStatus status;
    private String mensagem;
    private List<String> erros;

    public GlobalException(HttpStatus httpStatus, String localizedMessage, List<String> errors) {
        this.status = httpStatus;
        this.mensagem = localizedMessage;
        this.erros = errors;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

	@Override
	public String toString() {
		return "GlobalException [status=" + status + ", mensagem=" + mensagem + ", erros=" + erros + "]";
	}


}