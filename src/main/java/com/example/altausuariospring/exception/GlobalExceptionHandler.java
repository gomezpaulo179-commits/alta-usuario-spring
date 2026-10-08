package com.example.altausuariospring.exception;

import org.slf4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * spring detecta esta clase hay un @ComponentSacn... y aplica su @ExceptionHandler
 */
@ControllerAdvice
public class GlobalExceptionHandler {
  private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(FicheroNoEncontradoException.class)
    public String gestionarErrorFichero(FicheroNoEncontradoException ex, Model model) {
      LOGGER.error("Error con los ficheros de datos ", ex);
      model.addAttribute("mensajeError", ex.getMessage());
      return "error";
  }
}
