package com.moex.icdb.process.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import com.moex.icdb.process.model.Document;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DocumentService {

    private final KieContainer kieContainer;
    private final JavaMailSender mailSender;

    @Autowired
    public DocumentService(KieContainer kieContainer, JavaMailSender mailSender) {
        this.kieContainer = kieContainer;
        this.mailSender = mailSender;
    }

    public Document getDocumentByType(String type) {
        Document document = new Document();
        document.setType(type);
        applyBusinessRules(document);
        if (document.isNotifiedType()) send();
        return document;
    }

    private void applyBusinessRules(Document document) {
        KieSession kieSession = kieContainer.newKieSession("rulesSession");
        kieSession.insert(document);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    private void send() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("");
        simpleMailMessage.setSubject("Отправка уведомления");
        simpleMailMessage.setTo("");
        simpleMailMessage.setCc("");
        simpleMailMessage.setBcc("");
        simpleMailMessage.setText("Уведомление получено");
        mailSender.send(simpleMailMessage);
    }

}