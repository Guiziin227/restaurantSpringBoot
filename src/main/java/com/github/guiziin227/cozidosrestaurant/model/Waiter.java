package com.github.guiziin227.cozidosrestaurant.model;

import com.github.guiziin227.cozidosrestaurant.listener.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_waiter")
public class Waiter implements Serializable, Auditable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 120, nullable = false)
    private String name;

    @Column(length = 7, nullable = false, unique = true)
    private String accessCode;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Waiter waiter = (Waiter) o;
        return Objects.equals(id, waiter.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
