package com.hua.store.portal.service;

import com.hua.store.portal.pojo.ItemInfo;

public interface ItemService {

    public ItemInfo getItemById(Long itemId);

    public String getItemDescriptionById(Long itemId);

    public String getItemParameterById(Long itemId);
}
