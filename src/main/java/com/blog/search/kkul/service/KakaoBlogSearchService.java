package com.blog.search.kkul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import com.blog.search.kkul.repository.PopularKeywordRepository;
import com.blog.search.kkul.util.CommonUtil;
import com.blog.search.kkul.vo.KakaoBlogResponseVO;
import com.blog.search.kkul.vo.KakaoBlogSearchParamVO;

@Service
public class KakaoBlogSearchService {
    @Value("${blog.search.kakao.host}")
    private String kakaoBlogSearchHost;
    @Value("${blog.search.kakao.url}")
    private String kakaoBlogSearchUrl;
    @Value("${blog.search.kakao.auth}")
    private String kakaoBlogSearchAuth;
    @Value("${blog.search.kakao.rest-api-key}")
    private String kakaoBlogSearchRestApiKey;

    @Autowired 
    PopularKeywordRepository popularWordRepository;
    
    public Object findBlog(KakaoBlogSearchParamVO param){
        MultiValueMap<String, String> queryParam = CommonUtil.kakaoParamBuilder(param);
        return WebClient.create(kakaoBlogSearchHost)
                                    .get()
                                    .uri(uriBuilder ->
                                    uriBuilder.path(kakaoBlogSearchUrl)
                                        .queryParams(queryParam).build())
                                    .headers(headers -> {
                                        headers.add("Authorization", kakaoBlogSearchAuth+" "+kakaoBlogSearchRestApiKey);
                                    })
                                    .retrieve()
                                    .bodyToMono(KakaoBlogResponseVO.class)
                                    .block();
    }
}
