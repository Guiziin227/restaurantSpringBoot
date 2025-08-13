package com.github.guiziin227.cozidosrestaurant.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.guiziin227.cozidosrestaurant.listener.Auditable;
import com.github.guiziin227.cozidosrestaurant.listener.GenericAuditListener;
import com.github.guiziin227.cozidosrestaurant.model.enums.StatusTable;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_table")
@EntityListeners(GenericAuditListener.class)
public class Tables implements Serializable, Auditable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;

    private Integer capacity;

    @Enumerated(EnumType.STRING)
    private StatusTable status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tables tables = (Tables) o;
        return Objects.equals(id, tables.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
