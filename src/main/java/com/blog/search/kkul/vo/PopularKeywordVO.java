package com.blog.search.kkul.vo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="keyword")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PopularKeywordVO {
    @Id 
    @Column(name = "keyword")
    private String keyword;
    @Column(name = "hit")
    @Builder.Default
    private Long hit = 0L;
    public PopularKeywordVO(String keyword){
        this.setKeyword(keyword);
        this.hit = 0L;
    }
}
