package com.aqua404.autodbbackend.util;

import com.aqua404.autodbbackend.model.Field;
import com.aqua404.autodbbackend.model.QueryData;
import com.aqua404.autodbbackend.model.Table;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
@Slf4j
@RequiredArgsConstructor
public class GeneratorSQL {


    public static List<String> generateQueryFromData(QueryData queryData){
        List<String> listOfQuerys = new ArrayList<>();
        Optional<QueryData> opQueryData = Optional.of(queryData);
        var query = "";
        for (Table table: opQueryData.get().getTables()){
            query = "CREATE TABLE ";
            query =  query.concat(opQueryData.get().getSchema().concat("."));
            query = query.concat(table.getTableName().concat(" ( "));

            for (Field field: table.getFields() ){

                query =  query.concat(field.getName().concat(" ")
                        .concat(field.getType()));
                if (field.isNotNull()){
                    query =  query.concat(" not null ");
                }
                if (field.isUnique()){
                    query =  query.concat(" unique");
                }

                if (field.isPk()){
                    query =  query.concat(", CONSTRAINT ")
                            .concat(table.getTableName().concat("_pk")
                                    .concat(" PRIMARY KEY (")).concat(field.getName().concat(")"));
                }
                if (field.getFk() != null){
                        var fk = field.getFk();
                    query =  query.concat(", CONSTRAINT ")
                            .concat(table.getTableName().concat("_fk")
                                    .concat(" FOREIGN KEY (")).concat(field.getName().concat(")"))
                            .concat(" REFERENCES ")
                            .concat(queryData.getSchema().concat(".")
                                    .concat(fk.getTableName()
                                            .concat(" (").concat(fk.getPk().concat(")"))));
                }

                if (field.isFirstField()){
                    query = query.concat(", ");
                    field.setFirstField(false);
                }
                if (field.isLastfield()){
                    query = query.concat(");");
                }

            }
            listOfQuerys.add(query);

        }

        return listOfQuerys;
    }
}
