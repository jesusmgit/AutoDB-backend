package com.aqua404.autodbbackend.service;

import com.aqua404.autodbbackend.model.GenerateSqlResponse;
import com.aqua404.autodbbackend.model.QueryData;

import java.util.List;

public interface GenerateQueryService {


    List<String> generateQuery(QueryData queryData);
    GenerateSqlResponse generateQueryNEW(QueryData queryData);


}
