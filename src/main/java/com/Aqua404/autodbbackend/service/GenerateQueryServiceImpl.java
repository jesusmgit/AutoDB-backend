package com.aqua404.autodbbackend.service;

import com.aqua404.autodbbackend.model.Field;
import com.aqua404.autodbbackend.model.GenerateSqlResponse;
import com.aqua404.autodbbackend.model.QueryData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.aqua404.autodbbackend.util.Constants.*;
import static com.aqua404.autodbbackend.util.GeneratorSQL.generateQueryFromData;
import static com.aqua404.autodbbackend.util.GeneratorSQL.validateAndCleanString;

@Service
@Slf4j
@RequiredArgsConstructor
public class GenerateQueryServiceImpl implements GenerateQueryService {

    @Override
    public List<String> generateQuery(QueryData queryData) {
        validateFields(queryData);
        return generateQueryFromData(queryData);
    }

    @Override
    public GenerateSqlResponse generateQueryNEW(QueryData queryData) {
        validateFields(queryData);
        List<String> a = generateQueryFromData(queryData);
        if (a.isEmpty()){
            return GenerateSqlResponse.builder().status(HttpStatus.BAD_REQUEST).build();
        }
        return GenerateSqlResponse.builder().status(HttpStatus.OK).querys(a).build();
    }

    private String validateFields(QueryData queryData) {
        if (queryData.getSchema() == null ||
                queryData.getSchema().isBlank()) {
            queryData.setSchema(SCHEMA_DEFAULT);
        } else {
            queryData.setSchema(validateAndCleanString(queryData.getSchema()));
        }
        if (queryData.getTables().isEmpty()){
            return "no se ha recibido ninguna tabla";
        }

        for (int i = 0; i < queryData.getTables().size() ; i++) {
            if (queryData.getTables().get(i).getTableName() == null ||
                    queryData.getTables().get(i).getTableName().isBlank()){
                queryData.getTables().get(i).setTableName(NAME_TABLE_DEFAULT.concat(String.valueOf(i)));
            } else {
                queryData.getTables().get(i).setTableName(
                        validateAndCleanString(queryData.getTables().get(i).getTableName()));
            }
            if (queryData.getTables().get(i).getFields() == null){
                return "no se ha recibido ningún campo de las tablas";
            } else {
                for (int y = 0; y < queryData.getTables().get(i).getFields().size() ; y++) {
                    if (queryData.getTables().get(i).getFields().get(y).getName() == null ||
                            queryData.getTables().get(i).getFields().get(y).getName().isBlank()){
                        queryData.getTables().get(i).getFields().get(y).setName(DEFAULT_FIELD.concat(String.valueOf(y)));
                    } else {
                        queryData.getTables().get(i).getFields().get(y).setName(
                                validateAndCleanString(queryData.getTables().get(i).getFields().get(y).getName()));
                    }
                }
            }
        }
        return "OK";
    }

}
