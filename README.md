# AutoDB-backend

Backend API, to generate PostgreSQL Querys.

software used:
        IDE IntellIJ IDEA
        Maven project
        Postgresql (for tests, and features in progress).
        Java JDK 17.0.7


Implemented Methods:

checkHealth -> autodb-backend/checkHealth  
        Api to Check if the service is available via POST Petition

generate-sql -> autodb-backend/v1/generate-sql  
        Api expects a json object and converts objects into querys. The Api returns a List of querys.   
        The Api checks if the texts fields "schema", table_name", "name_field" and "type" are not empty setting defaults names to the fields.   
        
    example body:
    {
    "schema": "escuela",
    "tables": [
        {
            "table_name": "alumnos",
            "fields": [
                {
                    "name_field": "nombre",
                    "type": "varchar",
                    "pk": false,
                    "size": 20,
                    "non_null": false,
                    "fk": {
                        "table_name": "lista_alumnos",
                        "pk": "nombre"
                    },
                    "unique": true,
                    "autoincrement": false,
                    "first_field": true
                },
                {
                    "name_field": "id",
                    "type": "varchar",
                    "pk": true,
                    "size": 20,
                    "non_null": false,
                    "unique": true,
                    "autoincrement": false,
                    "last_field": true
                }
            ]
        },
        {
            "table_name": "profesores",
            "fields": [
                {
                    "name_field": "nombre",
                    "type": "varchar",
                    "pk": false,
                    "size": 20,
                    "non_null": false,
                    "fk": {
                        "table_name": "lista_profesores",
                        "pk": "nombre"
                    },
                    "unique": true,
                    "autoincrement": false,
                    "first_field": true
                },
                {
                    "name_field": "id",
                    "type": "varchar",
                    "pk": true,
                    "size": 20,
                    "non_null": false,
                    "unique": true,
                    "autoincrement": false,
                    "last_field": true
                }
            ]
        }
    ]}

    example return: 
    [
    "CREATE TABLE escuela.table0 ( nombre varchar unique, CONSTRAINT table0_fk FOREIGN KEY (nombre) REFERENCES escuela.lista_alumnos (nombre), id varchar unique, CONSTRAINT table0_pk PRIMARY KEY (id));",
    "CREATE TABLE escuela.table1 ( nombre varchar unique, CONSTRAINT table1_fk FOREIGN KEY (nombre) REFERENCES escuela.lista_profesores (nombre), id varchar unique, CONSTRAINT table1_pk PRIMARY KEY (id));"
    ]

