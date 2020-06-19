package com.spring.osworks.api.exceptionHandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data @AllArgsConstructor @NoArgsConstructor
public class Exception {
    private String titulo;
    private LocalDateTime dataHora;
    private Integer status;
    private List<Campo> campos;
}


