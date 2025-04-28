package com.Gustavo.AgendaEntregas.Exception.handler;

import java.util.Date;

public record ExceptionResponse (Date timestamp, String message, String details){
}
