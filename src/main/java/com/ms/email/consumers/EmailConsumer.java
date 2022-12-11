package com.ms.email.consumers;

import com.ms.email.dtos.EmailDto;
import com.ms.email.models.EmailModel;
import com.ms.email.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

//consumir o email e envia-lo para a fila

@Component//detecta os beans customizados automaticamente
public class EmailConsumer {

    @Autowired
    EmailService emailService;//chama os metodos de envio

    @RabbitListener(queues = "${spring.queue.name}")//consumir a fila que for passada
    public void listen(@Payload String email) {//passando a mensagem para a String
        emailService.sendEmail(email);//chamar o metodo de email para enviar o email em si
        System.out.println("Email Status: " + email);//mostrar o status do email
    }
}
