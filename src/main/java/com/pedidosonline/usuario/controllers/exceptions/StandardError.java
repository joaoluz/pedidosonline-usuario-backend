package com.pedidosonline.usuario.controllers.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class StandardError {

    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String path;

}


