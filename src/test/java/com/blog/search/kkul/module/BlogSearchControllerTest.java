package com.blog.search.kkul.module;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.blog.search.kkul.controller.BlogSearchController;
import com.blog.search.kkul.vo.KakaoBlogResponseVO;
import com.blog.search.kkul.vo.KakaoBlogSearchParamVO;
import com.blog.search.kkul.vo.KakaoBlogVO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BlogSearchControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    BlogSearchController blogSearchController;

    static final Logger logger = LoggerFactory.getLogger(BlogSearchControllerTest.class);
    @Test
    public void Keyword이효리_WhenUserFindSomething_ThenReturnKakaoData() throws Exception {
        KakaoBlogSearchParamVO param = new KakaoBlogSearchParamVO();//.builder().query("이효리").page(1).size(5).sort("recency").build();
        param.setPage(1);
        param.setQuery("더 글로리");
        param.setSize(5);
        param.setSort("recency");

        ResponseEntity<KakaoBlogResponseVO> response = restTemplate.postForEntity("/search/blog", param, KakaoBlogResponseVO.class);
        logger.info("response : {}" , response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(5, ((KakaoBlogResponseVO)(Optional.ofNullable(response.getBody()).orElseGet(() -> new KakaoBlogResponseVO()))).getDocuments().size());
    }
    
    @Test
    public void Keyword이효리_WhenUserFindSomethingWrongParams_ThenReturnErrorMessage() throws Exception {
        KakaoBlogVO param = KakaoBlogVO.builder().query("이효리").page(1).size(51).sort("recency").build();
        ResponseEntity<String> response = restTemplate.postForEntity("/search/blog", param, String.class);
        assertEquals(HttpStatus.EXPECTATION_FAILED, response.getStatusCode());
        assertEquals("Size 값을  1-50 사이의 값으로 입력하세요", response.getBody());

        param = KakaoBlogVO.builder().query("이효리").page(51).size(5).sort("recency").build();
        response = restTemplate.postForEntity("/search/blog", param, String.class);
        assertEquals(HttpStatus.EXPECTATION_FAILED, response.getStatusCode());
        assertEquals("Page 값을  1-50 사이의 값으로 입력하세요", response.getBody());

        param = KakaoBlogVO.builder().query("").page(1).size(5).sort("recency").build();
        response = restTemplate.postForEntity("/search/blog", param, String.class);
        assertEquals(HttpStatus.EXPECTATION_FAILED, response.getStatusCode());
        assertEquals("query 값은 필수입니다.", response.getBody());
    }
 
    @Test
    public void WhenUserCalledKeywords_ThenReturnKeywordTop10List() {
        ResponseEntity<List> response = 
                restTemplate.exchange("/keyword", HttpMethod.GET, null, List.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}