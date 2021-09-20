package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recognition_document")
public class Document {

    private Integer id;
    private DocumentGroup documentGroup;
    private DocumentTypeDefinition documentTypeDefinition;
    private boolean processed;
    private boolean error;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_group")
    public DocumentGroup getDocumentGroup() {
        return this.documentGroup;
    }

    public void setDocumentGroup(final DocumentGroup documentGroup) {
        this.documentGroup = documentGroup;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_type", nullable = false)
    public DocumentTypeDefinition getDocumentTypeDefinition() {
        return this.documentTypeDefinition;
    }

    public void setDocumentTypeDefinition(final DocumentTypeDefinition documentTypeDefinition) {
        this.documentTypeDefinition = documentTypeDefinition;
    }

    @Column(name = "processed", nullable = false)
    public boolean isProcessed() {
        return this.processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    @Column(name = "error", nullable = false)
    public boolean isError() {
        return this.error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
