package io.lua.util;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: ticket
 * @Package: io.lua.util
 * @Description:
 * @Author: AMGuo
 * @CreateDate: 2018-11-23 18:06
 * @Version: 1.0
 */
public class StationUtil {

    /**
     * @param name
     * @return
     */
    public static String getCodeByName(String name) {
        if (ObjectUtils.isEmpty(name)) {
            return null;
        }
        String result = HttpUtil.get("https://kyfw.12306.cn/otn/resources/js/framework/station_name.js?station_version=222");
        String temp = result.replace("var station_names ='", "");
        temp = temp.substring(0, temp.length() - 2);
        String[] array = temp.split("@");
        for (String s : array) {
            String[] split = s.split("\\|");
            if (split.length > 1 && split[1].equals(name)) {
                return split[2];
            }
        }
        return null;
    }

    /**
     * 查询余票
     *
     * @param from
     * @param to
     * @param date
     * @return
     */
    public static String getTickets(String from, String to, String date) {
        if (!ObjectUtils.isEmpty(from) && !ObjectUtils.isEmpty(to) && !ObjectUtils.isEmpty(date)) {
            Object[] param = new Object[]{date, from, to};
            String url = String.format("https://kyfw.12306.cn/otn/leftTicket/query?leftTicketDTO.train_date=%s&leftTicketDTO.from_station=%s&leftTicketDTO.to_station=%s&purpose_codes=ADULT", param);
            String s = HttpUtil.get(url);
            if (!ObjectUtils.isEmpty(s)) {
                JSONObject jsonObject = JSONObject.parseObject(s);
                return jsonObject.getJSONObject("data");
            }
            return null;
        }
        return null;
    }
}
