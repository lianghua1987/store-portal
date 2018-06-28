package com.hua.store.portal.service;

import com.hua.store.common.pojo.Result;
import com.hua.store.common.utils.HttpClientUtil;
import com.hua.store.common.utils.JsonUtils;
import com.hua.store.pojo.ItemDescription;
import com.hua.store.pojo.ItemParameter;
import com.hua.store.pojo.ItemParameterItem;
import com.hua.store.portal.pojo.ItemInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {

    @Value("${API_URL}")
    private String API_URL;

    @Value("${ITEM_INFO_URL}")
    private String ITEM_INFO_URL;

    @Value("${ITEM_DESC_URL}")
    private String ITEM_DESC_URL;

    @Value("${ITEM_PARAM_URL}")
    private String ITEM_PARAM_URL;


    @Override
    public ItemInfo getItemById(Long itemId) {

        try {
            String json = HttpClientUtil.doGet(API_URL + ITEM_INFO_URL + itemId);
            if (!StringUtils.isBlank(json)) {
                Result result = Result.formatToPojo(json, ItemInfo.class);
                if (result.getStatus() == 200) {
                    return (ItemInfo) result.getData();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String getItemDescriptionById(Long itemId) {
        try {
            String json = HttpClientUtil.doGet(API_URL + ITEM_DESC_URL + itemId);
            if (!StringUtils.isBlank(json)) {
                Result result = Result.formatToPojo(json, ItemDescription.class);
                if (result.getStatus() == 200) {
                    return ((ItemDescription) result.getData()).getItemDesc();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String getItemParameterById(Long itemId) {
        try {
            String json = HttpClientUtil.doGet(API_URL + ITEM_PARAM_URL + itemId);
            if (!StringUtils.isBlank(json)) {
                Result result = Result.formatToPojo(json, ItemParameterItem.class);
                if (result.getStatus() == 200) {
                    List<Map> list = JsonUtils.jsonToList(((ItemParameterItem) result.getData()).getParamData(), Map.class);

                    StringBuilder sb = new StringBuilder();

                    sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"1\">");
                    sb.append("<tbody>");

                    for (Map map : list) {
                        sb.append("<tr>");
                        sb.append("<th colspan=\"2\">" + map.get("group") + "</th>");
                        sb.append("</tr>");
                        List<Map> paramList = (List<Map>) map.get("params");

                        for (Map paramMap : paramList) {
                            sb.append("<tr>");
                            sb.append("<td>" + paramMap.get("k") + "</td>");
                            sb.append("<td>" + paramMap.get("v") + "</td>");
                            sb.append("</tr>");
                        }
                    }

                    sb.append("</tbody>");
                    sb.append("</table>");

                    return sb.toString();


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
}
