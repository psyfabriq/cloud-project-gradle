package ru.psyfabriq.enterprise.service;

import ru.psyfabriq.enterprise.model.CustomPrincipal;

import javax.servlet.http.HttpServletRequest;


public interface SystemInfoService {
    public CustomPrincipal getCurrentUser(HttpServletRequest request);
    public String getCurrentUserFolder();
    public String getLocalPath();
    public String getCurrentUserID();
    public String getWorkFolder();
    public boolean access();
}