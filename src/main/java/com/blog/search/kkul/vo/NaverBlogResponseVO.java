package com.blog.search.kkul.vo;
import java.util.List;

import lombok.Data;

@Data
public class NaverBlogResponseVO {
    private String lastBuildDate;
    private Integer total;
    private Integer start;
    private Integer display;
    private List<NaverItem> items;
}
