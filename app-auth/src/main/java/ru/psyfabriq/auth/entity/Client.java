package ru.psyfabriq.auth.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "oauth_client_details")
public class Client {
    @Id
    @Column(name = "client_id", columnDefinition = "VARCHAR(60)", nullable = false, unique = true)
    private String clientId;
    @Column(name = "access_token_validity", columnDefinition = "INT(6)")
    private int accessTokenValidity;
    @Column(name = "additional_information", columnDefinition = "VARCHAR(255)")
    private String additionalInformation;
    @Column(name = "authorities", columnDefinition = "VARCHAR(100)")
    private String authorities;
    @Column(name = "authorized_grant_types", columnDefinition = "VARCHAR(255)")
    private String authorizedGrantTypes;
    @Column(name = "autoapprove")
    private String autoapprove;
    @Column(name = "client_secret", columnDefinition = "VARCHAR(255)")
    private String clientSecret;
    @Column(name = "refresh_token_validity", columnDefinition = "INT(6)")
    private int refreshTokenValidity;
    @Column(name = "resource_ids", columnDefinition = "VARCHAR(255)")
    private String resourceIds;
    @Column(name = "scope", columnDefinition = "VARCHAR(250)")
    private String scope;
    @Column(name = "web_server_redirect_uri", columnDefinition = "VARCHAR(255)")
    private String webServerRedirectUri;

    @java.beans.ConstructorProperties({"clientId", "accessTokenValidity", "additionalInformation", "authorities", "authorizedGrantTypes", "autoapprove", "clientSecret", "refreshTokenValidity", "resourceIds", "scope", "webServerRedirectUri"})
    public Client(String clientId, int accessTokenValidity, String additionalInformation, String authorities, String authorizedGrantTypes, String autoapprove, String clientSecret, int refreshTokenValidity, String resourceIds, String scope, String webServerRedirectUri) {
        this.clientId = clientId;
        this.accessTokenValidity = accessTokenValidity;
        this.additionalInformation = additionalInformation;
        this.authorities = authorities;
        this.authorizedGrantTypes = authorizedGrantTypes;
        this.autoapprove = autoapprove;
        this.clientSecret = clientSecret;
        this.refreshTokenValidity = refreshTokenValidity;
        this.resourceIds = resourceIds;
        this.scope = scope;
        this.webServerRedirectUri = webServerRedirectUri;
    }

    public Client() {
    }

    public String getClientId() {
        return this.clientId;
    }

    public int getAccessTokenValidity() {
        return this.accessTokenValidity;
    }

    public String getAdditionalInformation() {
        return this.additionalInformation;
    }

    public String getAuthorities() {
        return this.authorities;
    }

    public String getAuthorizedGrantTypes() {
        return this.authorizedGrantTypes;
    }

    public String getAutoapprove() {
        return this.autoapprove;
    }

    public String getClientSecret() {
        return this.clientSecret;
    }

    public int getRefreshTokenValidity() {
        return this.refreshTokenValidity;
    }

    public String getResourceIds() {
        return this.resourceIds;
    }

    public String getScope() {
        return this.scope;
    }

    public String getWebServerRedirectUri() {
        return this.webServerRedirectUri;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setAccessTokenValidity(int accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public void setAutoapprove(String autoapprove) {
        this.autoapprove = autoapprove;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public void setRefreshTokenValidity(int refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Client)) return false;
        final Client other = (Client) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$clientId = this.getClientId();
        final Object other$clientId = other.getClientId();
        if (this$clientId == null ? other$clientId != null : !this$clientId.equals(other$clientId)) return false;
        if (this.getAccessTokenValidity() != other.getAccessTokenValidity()) return false;
        final Object this$additionalInformation = this.getAdditionalInformation();
        final Object other$additionalInformation = other.getAdditionalInformation();
        if (this$additionalInformation == null ? other$additionalInformation != null : !this$additionalInformation.equals(other$additionalInformation))
            return false;
        final Object this$authorities = this.getAuthorities();
        final Object other$authorities = other.getAuthorities();
        if (this$authorities == null ? other$authorities != null : !this$authorities.equals(other$authorities))
            return false;
        final Object this$authorizedGrantTypes = this.getAuthorizedGrantTypes();
        final Object other$authorizedGrantTypes = other.getAuthorizedGrantTypes();
        if (this$authorizedGrantTypes == null ? other$authorizedGrantTypes != null : !this$authorizedGrantTypes.equals(other$authorizedGrantTypes))
            return false;
        final Object this$autoapprove = this.getAutoapprove();
        final Object other$autoapprove = other.getAutoapprove();
        if (this$autoapprove == null ? other$autoapprove != null : !this$autoapprove.equals(other$autoapprove))
            return false;
        final Object this$clientSecret = this.getClientSecret();
        final Object other$clientSecret = other.getClientSecret();
        if (this$clientSecret == null ? other$clientSecret != null : !this$clientSecret.equals(other$clientSecret))
            return false;
        if (this.getRefreshTokenValidity() != other.getRefreshTokenValidity()) return false;
        final Object this$resourceIds = this.getResourceIds();
        final Object other$resourceIds = other.getResourceIds();
        if (this$resourceIds == null ? other$resourceIds != null : !this$resourceIds.equals(other$resourceIds))
            return false;
        final Object this$scope = this.getScope();
        final Object other$scope = other.getScope();
        if (this$scope == null ? other$scope != null : !this$scope.equals(other$scope)) return false;
        final Object this$webServerRedirectUri = this.getWebServerRedirectUri();
        final Object other$webServerRedirectUri = other.getWebServerRedirectUri();
        if (this$webServerRedirectUri == null ? other$webServerRedirectUri != null : !this$webServerRedirectUri.equals(other$webServerRedirectUri))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Client;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $clientId = this.getClientId();
        result = result * PRIME + ($clientId == null ? 43 : $clientId.hashCode());
        result = result * PRIME + this.getAccessTokenValidity();
        final Object $additionalInformation = this.getAdditionalInformation();
        result = result * PRIME + ($additionalInformation == null ? 43 : $additionalInformation.hashCode());
        final Object $authorities = this.getAuthorities();
        result = result * PRIME + ($authorities == null ? 43 : $authorities.hashCode());
        final Object $authorizedGrantTypes = this.getAuthorizedGrantTypes();
        result = result * PRIME + ($authorizedGrantTypes == null ? 43 : $authorizedGrantTypes.hashCode());
        final Object $autoapprove = this.getAutoapprove();
        result = result * PRIME + ($autoapprove == null ? 43 : $autoapprove.hashCode());
        final Object $clientSecret = this.getClientSecret();
        result = result * PRIME + ($clientSecret == null ? 43 : $clientSecret.hashCode());
        result = result * PRIME + this.getRefreshTokenValidity();
        final Object $resourceIds = this.getResourceIds();
        result = result * PRIME + ($resourceIds == null ? 43 : $resourceIds.hashCode());
        final Object $scope = this.getScope();
        result = result * PRIME + ($scope == null ? 43 : $scope.hashCode());
        final Object $webServerRedirectUri = this.getWebServerRedirectUri();
        result = result * PRIME + ($webServerRedirectUri == null ? 43 : $webServerRedirectUri.hashCode());
        return result;
    }

    public String toString() {
        return "Client(clientId=" + this.getClientId() + ", accessTokenValidity=" + this.getAccessTokenValidity() + ", additionalInformation=" + this.getAdditionalInformation() + ", authorities=" + this.getAuthorities() + ", authorizedGrantTypes=" + this.getAuthorizedGrantTypes() + ", autoapprove=" + this.getAutoapprove() + ", clientSecret=" + this.getClientSecret() + ", refreshTokenValidity=" + this.getRefreshTokenValidity() + ", resourceIds=" + this.getResourceIds() + ", scope=" + this.getScope() + ", webServerRedirectUri=" + this.getWebServerRedirectUri() + ")";
    }
}
