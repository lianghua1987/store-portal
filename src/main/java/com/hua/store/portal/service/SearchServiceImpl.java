package com.hua.store.portal.service;

import com.hua.store.common.pojo.Result;
import com.hua.store.common.utils.HttpClientUtil;
import com.hua.store.portal.pojo.SearchResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {
    @Value("${SEARCH_BASE_URL}")
    private String SEARCH_BASE_URL;

    @Override
    public SearchResult search(String query, Integer page) {

        Map<String, String> param = new HashMap<>();
        param.put("q", query);
        param.put("page", String.valueOf(page));
        try{
            String json = HttpClientUtil.doGet(SEARCH_BASE_URL, param);
            Result result = Result.formatToPojo(json, SearchResult.class);
            if(result.getStatus() == 200){
                return (SearchResult)result.getData();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
