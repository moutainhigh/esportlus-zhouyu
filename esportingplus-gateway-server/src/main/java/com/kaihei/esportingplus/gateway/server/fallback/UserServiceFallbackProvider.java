package com.kaihei.esportingplus.gateway.server.fallback;

import com.kaihei.esportingplus.common.ResponsePacket;
import com.kaihei.esportingplus.common.enums.BizExceptionEnum;
import com.kaihei.esportingplus.common.enums.ServicesEnum;
import com.kaihei.esportingplus.common.tools.FastJsonUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * 用户服务失败回退处理
 *
 * @author Orochi-Yzh
 * @dateTime 2018/6/21 16:28
 * @updatetor
 */
@Component
public class UserServiceFallbackProvider extends BaseFallbackProvider {

    public UserServiceFallbackProvider() {
        super.setServiceId(ServicesEnum.USER_SERVICE);
    }
}