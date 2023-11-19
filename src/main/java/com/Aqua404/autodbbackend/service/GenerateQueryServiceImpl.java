package com.aqua404.autodbbackend.service;

import com.aqua404.autodbbackend.model.QueryData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.aqua404.autodbbackend.util.Constants.NAME_TABLE_DEFAULT;
import static com.aqua404.autodbbackend.util.Constants.SCHEMA_DEFAULT;
import static com.aqua404.autodbbackend.util.GeneratorSQL.generateQueryFromData;

@Service
@Slf4j
@RequiredArgsConstructor
public class GenerateQueryServiceImpl implements GenerateQueryService {

    @Override
    public List<String> generateQuery(QueryData queryData) {
        return generateQueryFromData(queryData);
    }

    private QueryData validateFields(QueryData queryData) {
        if (queryData.getSchema() == null) {
            queryData.setSchema(SCHEMA_DEFAULT);
        }
        if (queryData.getTables().isEmpty()){
            return null;
        }

        for (int i = 0; i < queryData.getTables().size() ; i++) {
           var queryDataTemp = queryData.getTables().get(i);
            if (queryData.getTables().get(i).getTableName().isBlank()){
                queryData.getTables().get(i).setTableName(NAME_TABLE_DEFAULT.concat(String.valueOf(i)));
            }
            //if (queryData.getTables().get(i).getTableName().)

        }

        return null;
    }

}
