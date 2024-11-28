package br.com.william.nicolas.pmtrfinal.exceptions;

import lombok.*;

@Data
@AllArgsConstructor
public class ErrorMessageDTO {
    
    private String message;
    private String field;
}
