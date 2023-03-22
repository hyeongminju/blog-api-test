package com.blog.search.kkul.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.search.kkul.vo.KakaoBlogSearchParamVO;

@Service
public class BlogSearchService {

    @Autowired 
    KakaoBlogSearchService kakaoBlogSearchService;
    @Autowired 
    NaverBlogSearchService naverBlogSearchService;
    @Autowired 
    PopularKeywordService popularWordService;
    static final Logger logger = LoggerFactory.getLogger(BlogSearchService.class);

    public Object findBlog(KakaoBlogSearchParamVO param){
        popularWordService.increaseHit(param.getQuery());
        try {
            param.setQuery(URLEncoder.encode(param.getQuery(), StandardCharsets.UTF_8.toString()));
        } catch (UnsupportedEncodingException e) {
            logger.info("can not encoding string");
        }
        return Optional.ofNullable(kakaoBlogSearchService.findBlog(param))
                .orElseGet( () -> naverBlogSearchService.findBlog(param) );
    }
}