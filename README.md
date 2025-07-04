# SIGEDE API – Backend del Sistema de Gestión de Credenciales

Este es el backend de **SIGEDE**, una aplicación web que permite a instituciones crear credenciales personalizadas para su personal, usando formularios dinámicos, diseño de plantillas y generación automática de PDFs con QR.  
El backend está construido con **Spring Boot** y sigue una arquitectura RESTful, con autenticación por JWT y despliegue automatizado mediante **Jenkins y Docker** en instancias **AWS EC2**.

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
- Spring Security (JWT)
- MySQL
- JavaMailSender
- iTextPDF (PDFs)
- ZXing (QR)
- Docker + Docker Compose
- Jenkins (CI/CD)
- AWS EC2 (producción)
- Git y GitHub

---

## 📁 Estructura del proyecto

sigede_backend/
├── src/
│ ├── main/
│ │ ├── java/com/zeldib/sigede/
│ │ │ ├── controller/
│ │ │ ├── service/
│ │ │ ├── model/
│ │ │ └── repository/
│ └── resources/
│ └── application.properties
├── Dockerfile
├── docker-compose.yml
└── pom.xml

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

---

## 📦 Instalación local

### Requisitos

- Java 17
- MySQL
- Maven
- Docker (opcional)
- Archivo `.env` con variables requeridas

### Ejecución con Maven

# Compilar
mvn clean install

# Ejecutar
mvn spring-boot:run
