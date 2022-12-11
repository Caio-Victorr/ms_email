package com.ms.email.dtos;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

//padrão do springboot para facilitar o processamento com o banco de dados e comunicação client servidor
@Data//gerar os gets e sets
public class EmailDto {

    @NotBlank
    @Email
    private String emailFrom;
    @NotBlank
    @Email
    private String emailTo;
    @NotBlank
    private String subject;
    @NotBlank
    private String text;

}
