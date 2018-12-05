/*
 *    Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */

package com.kaihei.esportingplus.gateway.server.xss;

import com.kaihei.esportingplus.common.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;

/**
 * SQL过滤
 *
 * @author Orochi-Yzh
 * @dateTime 2018/6/29 18:10
 * @updatetor
 */
public class SqlFilter {

    /**
     * SQL注入过滤
     *
     * @param str 待验证的字符串
     */
    public static String sqlInject(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        //去掉'|"|;|\字符
        str = StringUtils.replace(str, "'", "");
        str = StringUtils.replace(str, "\"", "");
        str = StringUtils.replace(str, ";", "");
        str = StringUtils.replace(str, "\\", "");

        //转换成小写
        str = str.toLowerCase();

        //非法字符
        String[] keywords = {"master", "truncate", "insert", "select", "delete", "update",
                "declare", "alert", "drop"};

        //判断是否包含非法字符
        for (String keyword : keywords) {
            if (str.contains(keyword)) {
                throw new BusinessException(-1, "包含非法字符");
            }
        }

        return str;
    }
}
