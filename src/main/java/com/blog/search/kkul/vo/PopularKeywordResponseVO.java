package com.blog.search.kkul.vo;

import lombok.Data;

@Data
public class PopularKeywordResponseVO {
    private String keyword;
    private Long hit;
    public PopularKeywordResponseVO(PopularKeywordVO popularKeywordVO){
        this.keyword = popularKeywordVO.getKeyword();
        this.hit = popularKeywordVO.getHit();
    }
}
