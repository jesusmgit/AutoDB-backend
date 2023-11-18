package com.aqua404.autodbbackend.service;

import com.aqua404.autodbbackend.model.QueryData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.aqua404.autodbbackend.util.GeneratorSQL.generateQueryFromData;

@Service
@Slf4j
@RequiredArgsConstructor
public class GenerateQueryServiceImpl implements GenerateQueryService {

    //private final AutodbAuditDao dao;

    @Override
    public List<String> generateQuery(QueryData queryData){
        return generateQueryFromData(queryData);
    }

}
