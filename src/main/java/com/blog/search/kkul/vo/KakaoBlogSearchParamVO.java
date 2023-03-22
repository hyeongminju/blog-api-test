package com.blog.search.kkul.vo;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class KakaoBlogSearchParamVO {
    @NotEmpty(message = "query 값은 필수입니다.")
    private String query;
    @Pattern(regexp = "accuracy|recency")
    private String sort="accuracy";
    @Range(min=1, max=50, message = "Page 값을  1-50 사이의 값으로 입력하세요")
    private Integer page=1;
    @Range(min=1, max=50, message = "Size 값을  1-50 사이의 값으로 입력하세요")
    private Integer size=10;
}
