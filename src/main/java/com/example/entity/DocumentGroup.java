package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DocumentGroup {
    protected Integer id;
    protected Domain domain;
    protected DocumentTypeDefinition documentTypeDefinition;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "domain", nullable = false)
    public Domain getDomain() {
        return this.domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_type")
    public DocumentTypeDefinition getDocumentTypeDefinition() {
        return this.documentTypeDefinition;
    }

    public void setDocumentTypeDefinition(final DocumentTypeDefinition documentTypeDefinition) {
        this.documentTypeDefinition = documentTypeDefinition;
    }

}
