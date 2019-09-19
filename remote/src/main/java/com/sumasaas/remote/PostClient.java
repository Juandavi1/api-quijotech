package com.sumasaas.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 *
 */
@FeignClient(name="posts", url="${client.post}")
public interface PostClient {

    @RequestMapping(method = RequestMethod.GET, value = "/posts")
    List<RemotePost> getAll();

}
