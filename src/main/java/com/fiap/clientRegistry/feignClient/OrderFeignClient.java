package com.fiap.clientRegistry.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name = "orderManagement", path = "api/order")
public interface OrderFeignClient {

}
