package com.moex.icdb.process.controller;

import com.moex.icdb.process.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.moex.icdb.process.service.DocumentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentController {

    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @RequestMapping(value = "/documents", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Document> getDocumentByType(@RequestParam(required = true) String type) {
        final Document document = documentService.getDocumentByType(type);
        return new ResponseEntity<Document>(document, document.getHttpStatus());
    }
}
