package com.hua.store.portal.service;

import com.hua.store.portal.pojo.SearchResult;

public interface SearchService {

    public SearchResult search(String query, Integer page);
}
