package com.ms.email.services;

import com.ms.email.enums.StatusEmail;
import com.ms.email.models.EmailModel;
import com.ms.email.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

//responsavel por criar o serviço de email

@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;//salvar o escopo de email

    @Autowired
    private JavaMailSender emailSender;//interface que fornece as dependencias para o tipo de email

    public void sendEmail(String email) {//passa o email
        EmailModel emailModel = new EmailModel();//cria objeto email model
        UUID codgenerator = UUID.randomUUID();//gera o id
        emailModel.setCodconfirmation(codgenerator);//passa o codigo de confirmação(que chega no email)
        emailModel.setSendDateEmail(LocalDateTime.now());//passa a data e hora
        try{//processamento do metodo
            SimpleMailMessage message = new SimpleMailMessage();//objeto da mensagem
            message.setFrom("s6762731@gmail.com");
            message.setTo("caiofigueiredo94@gmail.com");
            message.setSubject("Confirmação Recebimento email do RabbitMQ");
            message.setText("Cadastro Confirmado com Sucesso. " +
                    "seu código de confirmação e: " + codgenerator);
            emailSender.send(message);//enviar a mensagem

            emailModel.setStatusEmail(StatusEmail.PROCESSING);//estatus para processando

            emailModel.setStatusEmail(StatusEmail.SENT);//estatus como enviado
        } catch (MailException e){
            emailModel.setStatusEmail(StatusEmail.ERROR);//se der errado estatus como erro
        } finally {
            emailRepository.save(emailModel);//salva o email no repositorio
        }
    }
}
