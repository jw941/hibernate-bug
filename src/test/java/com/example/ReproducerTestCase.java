package com.example;

import com.example.entity.DocumentTypeDefinition;
import com.example.entity.Domain;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@QuarkusTest
public class ReproducerTestCase {

    @Inject
    EntityManager em;

    @BeforeEach
    @Transactional
    public void setup() {
        Domain d = new Domain();
        d.setId(1);
        d.setLabel("test");
        em.merge(d);

        DocumentTypeDefinition dt = new DocumentTypeDefinition();
        dt.setId(1);
        dt.setName("test");
        em.merge(dt);
    }

    @Test
    @Transactional
    public void hqlTestCase() {
        Domain domain = em.find(Domain.class, 1);
        DocumentTypeDefinition documentTypeDefinition = em.find(DocumentTypeDefinition.class, 1);
        em.createQuery("update Document d set d.processed=false, d.error=false " +
                        "where d.documentGroup.domain=:domain " +
                        "and d.documentTypeDefinition=:documentTypeDefinition")
                .setParameter("domain", domain)
                .setParameter("documentTypeDefinition", documentTypeDefinition)
                .executeUpdate();
    }
}
