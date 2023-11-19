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

import static com.aqua404.autodbbackend.util.Constants.*;

@Component
@Slf4j
@RequiredArgsConstructor
public class GeneratorSQL {

    public static List<String> generateQueryFromData(QueryData queryData){
        Trimmer.trimObjectFields(queryData);
        List<String> listOfQuerys = new ArrayList<>();
        Optional<QueryData> opQueryData = Optional.of(queryData);
        List<String> pKList = new ArrayList<>();
        var query = "";
        for (Table table: opQueryData.get().getTables()){
            Trimmer.trimObjectFields(table);
            query = "CREATE TABLE ";

            query =  query.concat(opQueryData.get().getSchema().concat("."));
            query = query.concat(table.getTableName().concat(" ( "));

            for (Field field: table.getFields() ){
                Trimmer.trimObjectFields(field);

                query =  query.concat(field.getName().concat(" "));

                if (field.isAutoincrement()){
                    query = query.concat(SERIAL);
                    field.setType(SERIAL);
                } else{
                    query =  query.concat(field.getType());
                }

                if (field.getType().equals(TYPE_VARCHAR)){
                    if (field.getSize() == null){
                        query = query.concat(DEFAULT_SIZE_TYPE);
                    } else {
                        query = query.concat("(").concat(String.valueOf(field.getSize())).concat(")");
                    }
                }
                if (field.isNotNull()){
                    query =  query.concat(" not null ");
                }
                if (field.isUnique()){
                    query =  query.concat(" unique");
                }

                if (field.isPk()){
                    pKList.add(field.getName());
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

                if (table.getFields().size() == 1){
                    field.setFirstField(false);
                }
                if (field.isLastfield()){
                    if (!pKList.isEmpty()){
                        query = query.concat(", CONSTRAINT ")
                                .concat(table.getTableName().concat("_pk")
                                        .concat(" PRIMARY KEY ("));
                        for (int i = 0; i < pKList.size(); i++) {
                            if (i == pKList.size()-1){
                                query =  query.concat(pKList.get(i));
                            } else{
                                if (i != pKList.size() - 1){
                                    query =  query.concat(pKList.get(i).concat(", "));
                                }
                            }
                        }
                        query = query.concat(")");
                    }

                    query = query.concat(");");
                } else {
                    query = query.concat(", ");
                }

            }
            listOfQuerys.add(query);
            pKList = new ArrayList<>();

        }

        return listOfQuerys;
    }

    public static String validateAndCleanString(String input) {
        var regex = "[^a-zA-Z0-9_\\-.]";
        return input.replaceAll(regex, "");
    }
}
