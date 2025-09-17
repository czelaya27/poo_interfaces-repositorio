package org.czelaya.app.modelo;

import java.util.Objects;

public class BaseEntity {
    protected Integer id;
    private static Integer ultimoId = 0;

    public BaseEntity() {
        this.id = ++ultimoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        BaseEntity base = (BaseEntity) obj;
        return Objects.equals(id, base.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
