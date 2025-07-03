# SIGEDE API – Backend del Sistema de Gestión de Credenciales

Este es el backend de **SIGEDE** (Sistema de Gestión de Credenciales), desarrollado con **Spring Boot** y **MySQL**. Proporciona una API segura y estructurada para administrar formularios personalizados, usuarios, credenciales, generación de PDFs y más.

> 👉 Repositorio del frontend (Nuxt 3): [SIGEDE Web](https://github.com/ZelDIB/sigede_web)

---

## 🚀 Características principales

- 🔐 Autenticación con **JWT + Spring Security**
- 📄 Generación automática de credenciales en formato **PDF**
- 📥 Carga y almacenamiento de archivos/documentos en base de datos
- 🧾 Formularios configurables por institución
- 🎨 Plantillas visuales de credenciales
- 📷 Generación de **QRs** para agregar en las credenciales
- 👥 Gestión de usuarios con control de roles
- 🏢 Administración de instituciones y capturistas
- 🔧 CRUD completo para usuarios, formularios, credenciales e instituciones
- 📚 Documentación Swagger disponible

---

## ⚙️ Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security (con JWT)
- MySQL
- Lombok
- SpringDoc OpenAPI (Swagger)
- JavaMailSender (para notificaciones)
- iTextPDF (generación de PDFs)
- ZXing (generación de códigos QR)

---

## 📁 Variables de entorno requeridas

Tu archivo `application.properties` debe contener las variables necesarias:

- SPRING_DATASOURCE_URL=
- SPRING_DATASOURCE_USERNAME=
- SPRING_DATASOURCE_PASSWORD=
- SPRING_JPA_HIBERNATE_DDL_AUTO=update

- SPRING_MAIL_HOST=
- SPRING_MAIL_PORT=
- SPRING_MAIL_USERNAME=
- SPRING_MAIL_PASSWORD=

- JWT_SECRET=
- JWT_EXPIRATION=3600000

- API_BASE_URL=http://localhost:8080

## 🛠️ Ejecución local
Requisitos:
Java 17+

Maven

MySQL 8+

IDE como IntelliJ o VSCode

Pasos:
Clona el repositorio:

git clone https://github.com/ZelDIB/sigede_backend.git

cd sigede-api

Crea una base de datos llamada sigede en MySQL.

Configura las variables de entorno en tu entorno local o archivo .env.

Ejecuta el proyecto:

mvn spring-boot:run

El backend se iniciará en http://localhost:8080.
