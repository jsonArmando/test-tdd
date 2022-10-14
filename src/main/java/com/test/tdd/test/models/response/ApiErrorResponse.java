package com.test.tdd.test.models.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Slf4j
public class ApiErrorResponse {
    @Schema(name = "status", type = "Integer", description = "Código Http de respuesta")
    private final int status;

    @Schema(name = "message", type = "Integer", description = "Mensaje con el detalle del error")
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Schema(name = "errors", type = "List<ValidationErrorResponse>", description = "Listado de los errores de validación de los campos requeridos para ejecutar una petición")
    private final List<ValidationErrorResponse> errors = new ArrayList<>();


    @Getter
    @Setter
    @RequiredArgsConstructor
    private static class ValidationErrorResponse {

        @Schema(name = "field", type = "String", description = "Nombre del campo que presenta el error")
        private final String field;

        @Schema(name = "message", type = "String", description = "Detalle del mensaje de error que tiene el campo asociado a la validación")
        private final String message;
    }

    public void addValidationError(String field, String message){
        errors.add(new ValidationErrorResponse(field, message));
    }
    
}
