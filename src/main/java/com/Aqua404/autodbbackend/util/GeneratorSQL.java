package com.aqua404.autodbbackend.util;

import com.aqua404.autodbbackend.model.Field;
import com.aqua404.autodbbackend.model.QueryData;
import com.aqua404.autodbbackend.model.Table;

import java.util.Optional;

public class GeneratorSQL {

    /*
    *
    *
    CREATE TABLE public.test (
	id varchar NULL,
	person varchar NULL,
	CONSTRAINT test_pk PRIMARY KEY (id),
	CONSTRAINT test_fk FOREIGN KEY (person) REFERENCES public.person(id)
);

    *
    *
    * */
    public String generateQuery(QueryData queryData){
        Optional<QueryData> opQueryData = Optional.of(queryData);
        var query = "CREATE TABLE ";
        if (!opQueryData.get().getSchema().isBlank()){
            query.concat(opQueryData.get().getSchema().concat("."));
        }
        for (Table table: opQueryData.get().getTables()){
            query.concat(table.getTableName().concat(" ( "));

            for (Field field: table.getFields() ){
                query.concat(field.getName().concat(" ").concat(field.getType()).concat(","));
                if (field.isPk()){
                    query.concat("CONSTRAINT ")
                            .concat(table.getTableName().concat("_pk")
                                    .concat(" PRIMARY KEY (")).concat(field.getName().concat(")"));
                }
                if (field.getFk() != null){
                    var fk = field.getFk();
                    query.concat("CONSTRAINT ")
                            .concat(table.getTableName().concat("_fk")
                                    .concat(" FOREIGN KEY (")).concat(field.getName().concat(")"))
                            .concat("REFERENCES ")
                            .concat(queryData.getSchema().concat(".")
                                    .concat(fk.getTableName()
                                            .concat("(").concat(fk.getForeignField().concat(")") )));
                }
            }

        }

        return query;
    }
}
