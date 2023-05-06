Springboot Version: 3.0.3
Java Version: 17
gradle version: 7.6






Notes:
================
    To run gradle from command line:
        C:\Users\Prakash\Documents\Family\Mine\github\RestFullWebServiceExample\rest> .\gradlew.bat


    To call it from postman:
        url:
1.            http://localhost:8080/program

        output:
            {
                "id": 1,
                "name": "All Program List",
                "groupId": 1,
                "groupName": "Arrays"
            }

2. http://localhost:8080/actuator


===============================
Tries:
===============================
#https://www.baeldung.com/h2-embedded-db-data-storage
#spring.h2.console.enabled=true
#spring.datasource.url=jdbc:h2:mem:testdb
#spring.datasource.driverClassName=org.h2.Driver
#spring.datasource.username=sa
#spring.datasource.password=
#spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
#spring.data.jpa.repositories.bootstrap-mode=default


#spring.sql.init.mode=never
