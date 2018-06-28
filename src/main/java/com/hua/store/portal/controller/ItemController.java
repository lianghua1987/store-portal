package com.hua.store.portal.controller;

import com.hua.store.portal.pojo.ItemInfo;
import com.hua.store.portal.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ItemController {

    @Autowired
    private ItemService service;

    @RequestMapping("/item/{itemId}")
    public String getItemById(@PathVariable Long itemId, Model model) {
        ItemInfo itemInfo = service.getItemById(itemId);
        model.addAttribute("item", itemInfo);
        return "item";
    }


    @RequestMapping(value = "/item/desc/{itemId}", produces = MediaType.TEXT_HTML_VALUE + ";charset=utf-8 ")
    @ResponseBody
    public String getItemDescriptionById(@PathVariable Long itemId) {
        return service.getItemDescriptionById(itemId);
    }

    @RequestMapping(value = "/item/param/{itemId}", produces = MediaType.TEXT_HTML_VALUE + ";charset=utf-8 ")
    @ResponseBody
    public String getItemParameterById(@PathVariable Long itemId) {
        return service.getItemParameterById(itemId);
    }
}
