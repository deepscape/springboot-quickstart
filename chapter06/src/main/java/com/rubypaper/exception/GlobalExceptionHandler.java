package com.rubypaper.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BoardException.class)
	public String handleCustomException(BoardException exception, Model model) {
		model.addAttribute("exception", exception);
		return "/errors/boardError";
	}

	// 위의 BoardException 타입 예외를 제외한 나머지 모든 예외 처리
	@ExceptionHandler(Exception.class)
	public String handleException(Exception exception, Model model) {
		model.addAttribute("exception", exception);
		return "/errors/globalError";
	}

	// SQLException 에 대한 별도의 예외 처리 로직 구현
	@ExceptionHandler(SQLException.class)
	public String numberFormatError(SQLException exception, Model model) {
		model.addAttribute("exception", exception);
		return "/errors/sqlError";
	}
}
