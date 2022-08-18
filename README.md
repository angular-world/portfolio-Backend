# 💻 Portfolio Web - #YoProgramo
![GitHub Release Date](https://img.shields.io/github/release-date/burgosmanuel/portfolio-frontend) ![GitHub followers](https://img.shields.io/github/followers/burgosmanuel?style=social)

*NOTA: En este repositorio se encuentra todo lo relacionado al **Backend** del proyecto, para dirigirse al repositorio del **Frotend** **[hacer click aquí](http://github.com/BurgosManuel/portfolio-Frontend "aquí").***
## 📝 Descripción
- ***Backend** del **Portfolio Web Fullstack*** realizado como Proyecto Final del curso **Argentina Programa - #YoProgramo**.

- Se trata de una **API REST** realizada utilizando las tecnologías **Java + Spring Boot** bajo el modelo **MVC** para la lógica y **MySQL** para persistencia de datos.

- A continuación se incluye el **Diagrama Entidad - Relación** (DER) utilizado en la Base de Datos Relacional y que posteriormente se traduce en los Modelos o Entidades del Backend:

<div align="center">
<img src="https://user-images.githubusercontent.com/83843908/185244851-4ea65a5f-1565-44ed-86cd-52464b1bea12.png" width="800px">
</div>

## ✅ Como utilizar la API
- La documentación completa de la API, fue realizada utilizando Swagger UI con Spring Boot. Para acceder a la misma se puede <b>[hacer click aquí.](https://api.burgosmanuel.ar/swagger-ui/index.html)</b>

## ⌨🖱 Instalación
- Si queremos correr la aplicación en un entorno local debemos tener en cuenta lo siguiente: 

1. Clonar el repositorio utilizando GIT o descargando el archivo ZIP:

    `git clone https://github.com/BurgosManuel/portfolio-Backend.git`

2. Instalar las dependencias de Maven utilizando nuestro IDE preferido o a través del comando:

    `mvn install`

3. Crear/Configurar el archivo _application.properties_ en src/main/resources/

```properties
spring.jpa.hibernate.ddl-auto = update
spring.datasource.url = jdbc:mysql://<host_DB>:<puerto_DB>/<nombre_DB>?serverTimezone=UTC&createDatabaseIfNotExist=true
spring.datasource.username = <usuario>
spring.datasource.password= <contraseña>
spring.jpa.database-platform = org.hibernate.dialect.MySQL8Dialect
portfolio.jwtSecret = <clave_alfanumérica_JWT>
portfolio.jwtExpirationMs = <tiempo_expiración_JWT> 
```
NOTA: Reemplazar los valores borrando los <>.

4. Ejecutar nuestra aplicación iniciando el archivo `PortfolioApplication.Java` o bien ejecutando el siguiente comando:
    `mvn sprin-boot:run`

## 📩 Contacto
🙋‍♂️Si tienes dudas o te interesa ponerte en contacto conmigo podés hacerlo a través de:
**[LinkedIn](https://linkedin.com/in/burgosmanuel-dev) - [Github](https://github.com/BurgosManuel) - [Web](https://burgosmanuel.ar)**
