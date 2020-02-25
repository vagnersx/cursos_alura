package br.com.vagner.config.validacao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import br.com.vagner.controller.dto.ErroDeFormularioDTO;

@RestControllerAdvice
public class ErroDeValidacaoHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDeFormularioDTO> handleNotValid(MethodArgumentNotValidException exception) {
		
		return exception.getBindingResult().getFieldErrors()
				.stream()
				.map(fieldError -> {
					String mensagem  = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
					return new ErroDeFormularioDTO(fieldError.getField(), mensagem);
				})
				.collect(Collectors.toList());
	}
	
//	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
//	@ExceptionHandler({HttpMessageNotReadableException.class, MissingServletRequestParameterException.class})
//	public List<ErroDeFormularioDTO> handleBadRequest(Exception exception) {
//		ErroDeFormularioDTO dto = new ErroDeFormularioDTO("BAD_REQUEST", "Erro de sintaxe");
//		return Arrays.asList(dto);
//	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler({EntityNotFoundException.class, MethodArgumentTypeMismatchException.class})
	public void handleNotReadable(Exception exception) {

	}
	
//	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(Throwable.class)
//	public List<ErroDeFormularioDTO> handleInternalServerError(Throwable exception) {
//		ErroDeFormularioDTO erroDeFormularioDTO = new ErroDeFormularioDTO("Erro desconhecido", "Ocorreu um erro desconhecido");
//		return Arrays.asList(erroDeFormularioDTO);
//	}
	
}
