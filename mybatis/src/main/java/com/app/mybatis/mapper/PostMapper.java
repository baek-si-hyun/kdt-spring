package com.app.mybatis.mapper;

import com.app.mybatis.domain.PostDTO;
import com.app.mybatis.domain.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {
    public void insert(PostVO postVO);
    public List<PostVO> selectAll();
    public Optional<PostDTO> select(Long id);
    public void update(PostVO postVO);
    public void delete(Long id);
}
