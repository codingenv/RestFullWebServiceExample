Springboot Version: 2.7.1
Java Version: 17
gradle version: 7.6






Notes:
================
    To run gradle from command line:
        C:\Users\Prakash\Documents\Family\Mine\github\RestFullWebServiceExample\rest> .\gradlew.bat


    To call it from postman:
        url:
1.            http://localhost:8080/collage/student

        output:
[
    {
        "id": 1,
        "name": "Prakash",
        "city": "Bangalore",
        "age": 14,
        "std": 12,
        "stream": "Science"
    },
    {
        "id": 2,
        "name": "Prateek",
        "city": "Surat",
        "age": 13,
        "std": 11,
        "stream": "Arts"
    }
]

2. http://localhost:8080/actuator

Output:

{
    "_links": {
        "self": {
            "href": "http://localhost:8080/actuator",
            "templated": false
        },
        "health": {
            "href": "http://localhost:8080/actuator/health",
            "templated": false
        },
        "health-path": {
            "href": "http://localhost:8080/actuator/health/{*path}",
            "templated": true
        }
    }
}


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
