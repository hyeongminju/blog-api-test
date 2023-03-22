package com.blog.search.kkul.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.blog.search.kkul.vo.PopularKeywordVO;

@Repository
public interface PopularKeywordRepository extends JpaRepository <PopularKeywordVO, String> {
    public List<PopularKeywordVO> findTop10ByOrderByHitDesc();
    @Modifying
    @Transactional
    @Query("UPDATE PopularKeywordVO SET hit = hit + 1L WHERE keyword = :keyword")
    Integer increaseHit(@Param("keyword") String keyword);
}