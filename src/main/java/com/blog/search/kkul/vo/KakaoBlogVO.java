package com.blog.search.kkul.vo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KakaoBlogVO {
    private String query;
    private String sort;
    private Integer page;
    private Integer size;
}
