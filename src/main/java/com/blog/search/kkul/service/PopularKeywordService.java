package com.blog.search.kkul.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blog.search.kkul.repository.PopularKeywordRepository;
import com.blog.search.kkul.vo.PopularKeywordResponseVO;
import com.blog.search.kkul.vo.PopularKeywordVO;

@Service
public class PopularKeywordService {
    @Autowired 
    PopularKeywordRepository popularWordRepository;
    public void increaseHit(String keyword){
        popularWordRepository.findById(keyword).orElseGet(() -> popularWordRepository.save(new PopularKeywordVO(keyword)));
        popularWordRepository.increaseHit(keyword);
    }
    
    public List<PopularKeywordResponseVO> getPopularKeywordTop10(){
        return popularWordRepository.findTop10ByOrderByHitDesc().stream()
                                    .map(PopularKeywordResponseVO::new)
                                    .collect(Collectors.toList());
    }
}
