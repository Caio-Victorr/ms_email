package com.ms.email.controllers;


import com.ms.email.dtos.EmailDto;
import com.ms.email.dtos.RequestDto;
import com.ms.email.models.EmailModel;
import com.ms.email.services.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

//vai ser remodelado

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    //parte de confirmação do email(não pronto)
    @PostMapping("/confirm-email")
    public ResponseEntity<EmailModel> confirmemail(@RequestBody @Valid EmailDto emailDto) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);
       //emailService.sendEmail(emailModel);
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
    }

}
