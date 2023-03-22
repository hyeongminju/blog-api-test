package com.blog.search.kkul.vo;
import java.util.List;

import lombok.Data;

@Data
public class KakaoBlogResponseVO {
    private KakaoMeta meta;
    private List<KakaoDocument> documents;
}
