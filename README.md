Проект: базовая конфигурация Spring Cloud + Gradle + Angular 7
========================

## Используемый стек технологий:
- Server-side: Java 8, Spring-Cloud, Hibernate, JPA, MySQL.
- Client-side: html, Angular 7, Bootstrap.
- Mobile-client-side: Android Application

## Spring Cloud стек технологий:
- Zuul (app-gateway)
- Eureka (app-discovery)
- Configuration Server (app-config)
- Authorization Server (JWT Token) (app-auth)
- Resource Server (app-enterprise)

## Описание:
Данный проект является базовым , демонстрирующий возможности построения проектов с использованием Framework Spring Boot (Cloud). В данном проекте построены базовые сервисы:
- Сервис конфигурации - нужен для хранения конфигураций других сервисов
- Сервис балансира - нужен для распределения нагрузки сервисов и масштабирования проекта
- Сервис прокси - единая точка входа для работы со всеми сервисами
- Сервис Авторизации и Аутентификации - безопасность и распределения прав доступа
- Сервис Бизнес логики - это  и есть сам проект
- Сервис Site UI и Admin UI - пользовательский и административный интерфейс
- Android Application - клиентское по работающее с сервисом Бизнес логики и сервисом Авторизации
## 
В качестве предметной области , использован проект “Файловое хранилище”  
https://github.com/psyfabriq/storage 
