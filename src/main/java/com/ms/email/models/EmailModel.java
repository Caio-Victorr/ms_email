package com.ms.email.models;

import com.ms.email.enums.StatusEmail;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data// criar gets e sets(encapsulamento)
@Entity//definir a classe como entidade do banco de dados
@Table(name = "t_emails")// referencia a tabela no banco
public class EmailModel {//escreve o escopo de um email
    private static final long serialVersionUID = 1L;

    @Id//definir chave primaria
    @GeneratedValue(strategy= GenerationType.AUTO)//gerar um id automatico a cada inserção no banco
    private UUID emailId; //id do email
    private UUID codconfirmation;//codigo de comparação
    private String emailFrom;//email que envia
    private String emailTo;//email que recebe
    private String subject;//titulo do emial
    @Column(columnDefinition = "TEXT")//defina o texto como ilimitado removendo os limites do String
    private String text;//texto
    private LocalDateTime sendDateEmail;//data e hora que foi enviado o email
    private StatusEmail statusEmail;//em que estado esta o email(enviado, processando, error)
}
