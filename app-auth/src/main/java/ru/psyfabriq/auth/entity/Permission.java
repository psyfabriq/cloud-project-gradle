package ru.psyfabriq.auth.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "permission")
public class Permission extends BaseIdEntity {
    @Column(columnDefinition = "VARCHAR(60)", nullable = false)
    private String name;

    @java.beans.ConstructorProperties({"name"})
    public Permission(String name) {
        this.name = name;
    }

    public Permission() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Permission(name=" + this.getName() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Permission)) return false;
        final Permission other = (Permission) o;
        if (!other.canEqual((Object) this)) return false;
        if (!super.equals(o)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Permission;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        return result;
    }
}
