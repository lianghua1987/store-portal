package com.hua.store.portal.controller;

import com.hua.store.portal.pojo.SearchResult;
import com.hua.store.portal.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
public class SearchController {

    @Autowired
    private SearchService service;

    @RequestMapping("/search")
    public String search(@RequestParam("q") String query, @RequestParam(defaultValue = "1")Integer page, Model model){
        try{
            if(query != null){
                query = new String(query.getBytes("iso8859-1"), "utf-8");
            }
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        SearchResult result = service.search(query, page);
        model.addAttribute("query", query);
        model.addAttribute("totalPages", result.getTotalCount());
        model.addAttribute("itemList", result.getItems());
        model.addAttribute("page", page);
        return "search";
    }

}
