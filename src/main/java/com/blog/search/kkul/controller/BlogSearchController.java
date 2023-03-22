package com.blog.search.kkul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.search.kkul.service.BlogSearchService;
import com.blog.search.kkul.service.PopularKeywordService;
import com.blog.search.kkul.vo.KakaoBlogSearchParamVO;

import jakarta.validation.Valid;


@RestController
public class BlogSearchController {
    @Autowired
    BlogSearchService blogSearchService;
    @Autowired
    PopularKeywordService popularKeywordService;
    @PostMapping("/search/blog")
    public ResponseEntity<Object> kakaoBlogSearch(@Valid @RequestBody(required = false) KakaoBlogSearchParamVO param){
        return new ResponseEntity<>(blogSearchService.findBlog(param), HttpStatus.OK);
    }
    @GetMapping("/keyword")
    public ResponseEntity<Object> getKeyword(){
        return new ResponseEntity<>(popularKeywordService.getPopularKeywordTop10(), HttpStatus.OK);
    }
}
