# Java API Service Starter

This is a minimal Java API service starter based on [Google Cloud Run Quickstart](https://cloud.google.com/run/docs/quickstarts/build-and-deploy/deploy-java-service).

## Getting Started

Server should run automatically when starting a workspace. To run manually, run:
```sh
mvn spring-boot:run
```
## Ramas en desarrollo
ejecutar el comando: mysqldump -u root  itsudb > datos_iniciales.sql
                    para exportar los datos que han cargado en la base de datos
## Nuevas ramas
ejecutar el comando en la consola: 
                    "mysql -u usuario -p nombre_base_datos < datos_iniciales.sql"
                     para poblar la base de datos con información inicial 