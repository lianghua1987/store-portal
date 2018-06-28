package com.hua.store.portal.pojo;

import com.hua.store.pojo.Item;

public class ItemInfo extends Item {

    public String[] getImages() {
        String image = getImage();
        if (image != null) {
            return image.split(",");
        }
        return null;
    }


}
