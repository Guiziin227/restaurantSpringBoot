package com.github.guiziin227.cozidosrestaurant.listener;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.format.DateTimeFormatter;

public class GenericAuditListener {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @PrePersist
    public void prePersist(Object entity) {
        if (entity instanceof Auditable auditable) {
            var now = java.time.LocalDateTime.now();
            auditable.setCreatedAt(now);
            auditable.setUpdatedAt(now);
            System.out.println("Entity created at: " + now.format(formatter));
        }
    }

    @PreUpdate
    public void preUpdate(Object entity) {
        if (entity instanceof Auditable auditable) {
            var now = java.time.LocalDateTime.now();
            auditable.setUpdatedAt(now);
        }
    }
}
