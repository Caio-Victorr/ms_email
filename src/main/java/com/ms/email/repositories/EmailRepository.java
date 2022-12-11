package com.ms.email.repositories;

import com.ms.email.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

//Os emails são salvos por essa interface armazenando os usuarios e os IDs dos emails
public interface EmailRepository extends JpaRepository<EmailModel, UUID> {

    //@Query (value = "", nativeQuery = true)
    //public boolean verifyRequestquery();
}
