package com.blog.search.kkul.vo;
import lombok.Data;

@Data
public class KakaoMeta {
    private Long total_count ;
    private Long pageable_count;
    private Boolean is_end;
}
