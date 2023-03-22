package com.blog.search.kkul.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import com.blog.search.kkul.repository.PopularKeywordRepository;
import com.blog.search.kkul.util.CommonUtil;
import com.blog.search.kkul.vo.KakaoBlogSearchParamVO;
import com.blog.search.kkul.vo.NaverBlogResponseVO;


@Service
public class NaverBlogSearchService {
    @Value("${blog.search.naver.host}")
    private String naverBlogSearchHost;
    @Value("${blog.search.naver.uri}")
    private String naverBlogSearchUri;
    @Value("${blog.search.naver.client-id}")
    private String naverBlogSearchClientId;
    @Value("${blog.search.naver.client-secret}")
    private String naverBlogSearchClientSecret;

    @Autowired 
    PopularKeywordRepository popularWordRepository;
    
    public Object findBlog(KakaoBlogSearchParamVO param){
        MultiValueMap<String, String> queryParam = CommonUtil.naverParamBuilder(param);
        return WebClient.create(naverBlogSearchHost)
                                    .get()
                                    .uri(uriBuilder ->
                                    uriBuilder.path(naverBlogSearchUri)
                                        .queryParams(queryParam).build())
                                    .headers(headers -> {
                                        headers.add("X-Naver-Client-Id", naverBlogSearchClientId);
                                        headers.add("X-Naver-Client-Secret", naverBlogSearchClientSecret);
                                    })
                                    .retrieve()
                                    .bodyToMono(NaverBlogResponseVO.class)
                                    .block();
    }
}
