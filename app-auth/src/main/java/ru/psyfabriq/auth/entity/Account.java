package ru.psyfabriq.auth.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "account")
public  class Account extends BaseIdEntity<String> implements UserDetails {

    @Column(columnDefinition = "VARCHAR(25)", nullable = false, unique = true)
    private String username;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String password;

    @Column(columnDefinition = "VARCHAR(40)", nullable = false, unique = true)
    private String email;

    @Column(columnDefinition = "VARCHAR(40)")
    private String firstName;

    @Column(columnDefinition = "VARCHAR(40)")
    private String lastName;

    @Column(columnDefinition = "INT(1)")
    private boolean enabled;

    @Column(name = "account_locked", columnDefinition = "INT(1)")
    private boolean accountNonLocked;

    @Column(name = "account_expired", columnDefinition = "INT(1)")
    private boolean accountNonExpired;

    @Column(name = "credentials_expired", columnDefinition = "INT(1)")
    private boolean credentialsNonExpired;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_account", joinColumns = {
            @JoinColumn(name = "account_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

    @java.beans.ConstructorProperties({"username", "password", "email", "firstName", "lastName", "enabled", "accountNonLocked", "accountNonExpired", "credentialsNonExpired", "roles"})
    public Account(String username, String password, String email, String firstName, String lastName, boolean enabled, boolean accountNonLocked, boolean accountNonExpired, boolean credentialsNonExpired, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enabled = enabled;
        this.accountNonLocked = accountNonLocked;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.roles = roles;
    }

    public Account() {
    }

    public static AccountBuilder builder() {
        return new AccountBuilder();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        roles.forEach(r -> {
            authorities.add(new SimpleGrantedAuthority(r.getName()));
            r.getPermissions().forEach(p -> {
                authorities.add(new SimpleGrantedAuthority(p.getName()));
            });
        });
        return authorities;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    public List<Role> getRoles() {
        return this.roles;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String toString() {
        return "Account(username=" + this.getUsername() + ", password=" + this.getPassword() + ", email=" + this.getEmail() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", enabled=" + this.isEnabled() + ", accountNonLocked=" + this.isAccountNonLocked() + ", accountNonExpired=" + this.isAccountNonExpired() + ", credentialsNonExpired=" + this.isCredentialsNonExpired() + ", roles=" + this.getRoles() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Account)) return false;
        final Account other = (Account) o;
        if (!other.canEqual((Object) this)) return false;
        if (!super.equals(o)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$firstName = this.getFirstName();
        final Object other$firstName = other.getFirstName();
        if (this$firstName == null ? other$firstName != null : !this$firstName.equals(other$firstName)) return false;
        final Object this$lastName = this.getLastName();
        final Object other$lastName = other.getLastName();
        if (this$lastName == null ? other$lastName != null : !this$lastName.equals(other$lastName)) return false;
        if (this.isEnabled() != other.isEnabled()) return false;
        if (this.isAccountNonLocked() != other.isAccountNonLocked()) return false;
        if (this.isAccountNonExpired() != other.isAccountNonExpired()) return false;
        if (this.isCredentialsNonExpired() != other.isCredentialsNonExpired()) return false;
        final Object this$roles = this.getRoles();
        final Object other$roles = other.getRoles();
        if (this$roles == null ? other$roles != null : !this$roles.equals(other$roles)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Account;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $firstName = this.getFirstName();
        result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
        final Object $lastName = this.getLastName();
        result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
        result = result * PRIME + (this.isEnabled() ? 79 : 97);
        result = result * PRIME + (this.isAccountNonLocked() ? 79 : 97);
        result = result * PRIME + (this.isAccountNonExpired() ? 79 : 97);
        result = result * PRIME + (this.isCredentialsNonExpired() ? 79 : 97);
        final Object $roles = this.getRoles();
        result = result * PRIME + ($roles == null ? 43 : $roles.hashCode());
        return result;
    }

    public static class AccountBuilder {
        private String username;
        private String password;
        private String email;
        private String firstName;
        private String lastName;
        private boolean enabled;
        private boolean accountNonLocked;
        private boolean accountNonExpired;
        private boolean credentialsNonExpired;
        private List<Role> roles;

        AccountBuilder() {
        }

        public Account.AccountBuilder username(String username) {
            this.username = username;
            return this;
        }

        public Account.AccountBuilder password(String password) {
            this.password = password;
            return this;
        }

        public Account.AccountBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Account.AccountBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Account.AccountBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Account.AccountBuilder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Account.AccountBuilder accountNonLocked(boolean accountNonLocked) {
            this.accountNonLocked = accountNonLocked;
            return this;
        }

        public Account.AccountBuilder accountNonExpired(boolean accountNonExpired) {
            this.accountNonExpired = accountNonExpired;
            return this;
        }

        public Account.AccountBuilder credentialsNonExpired(boolean credentialsNonExpired) {
            this.credentialsNonExpired = credentialsNonExpired;
            return this;
        }

        public Account.AccountBuilder roles(List<Role> roles) {
            this.roles = roles;
            return this;
        }

        public Account build() {
            return new Account(username, password, email, firstName, lastName, enabled, accountNonLocked, accountNonExpired, credentialsNonExpired, roles);
        }

        public String toString() {
            return "Account.AccountBuilder(username=" + this.username + ", password=" + this.password + ", email=" + this.email + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", enabled=" + this.enabled + ", accountNonLocked=" + this.accountNonLocked + ", accountNonExpired=" + this.accountNonExpired + ", credentialsNonExpired=" + this.credentialsNonExpired + ", roles=" + this.roles + ")";
        }
    }
}

