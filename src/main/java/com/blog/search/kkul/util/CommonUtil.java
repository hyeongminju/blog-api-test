package com.blog.search.kkul.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.blog.search.kkul.vo.KakaoBlogSearchParamVO;

public class CommonUtil {
    public static MultiValueMap<String, String> kakaoParamBuilder(KakaoBlogSearchParamVO param){
        MultiValueMap<String, String> queryParam = new LinkedMultiValueMap<>();
        queryParam.add("query",param.getQuery());
        queryParam.add("page",param.getPage()+"");
        queryParam.add("size",param.getSize()+"");
        queryParam.add("sort",param.getSort());
        return queryParam;
    }
    public static MultiValueMap<String, String> naverParamBuilder(KakaoBlogSearchParamVO param){
        MultiValueMap<String, String> queryParam = new LinkedMultiValueMap<>();
        queryParam.add("query",param.getQuery());
        queryParam.add("start",param.getPage()+"");
        queryParam.add("display",param.getSize()+"");
        queryParam.add("sort", StringUtils.equals(param.getSort() , "accuracy" ) ? "sim" : "date" );
        return queryParam;
    }
}
