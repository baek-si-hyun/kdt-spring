package com.app.mybatis.mapper;

import com.app.mybatis.domain.MemberVO;
import com.app.mybatis.domain.PostDTO;
import com.app.mybatis.domain.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MapperTests {

    @Autowired
    public MemberMapper memberMapper;

    @Autowired
    public PostMapper postMapper;

    @Test
    public void postDeleteTest(){
        postMapper.select(1L).map(PostDTO::getId).ifPresent(postMapper::delete);
    }

    @Test
    public void postUpdateTest(){
        postMapper.select(1L).ifPresent(postDTO -> {
            PostVO postVO = new PostVO();
            postDTO.setPostTitle("수정된 제목1");
            postDTO.setPostContent("수정된 내용1");

            postVO.setId(postDTO.getId());
            postVO.setPostTitle(postDTO.getPostTitle());
            postVO.setPostContent(postDTO.getPostContent());
            postMapper.update(postVO);
        });
    }

    @Test
    public void postSelectTest(){
        postMapper.select(1L).map(PostDTO::toString).ifPresent(log::info);
    }

    @Test
    public void postSelectAllTest(){
        postMapper.selectAll().stream().map(PostVO::toString).forEach(log::info);
    }

    @Test
    public void postInsertTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("qortlgus100@gmail.com");
        memberVO.setMemberPassword("1234");
        memberMapper.select(memberVO).map(MemberVO::getId).ifPresent(
                memberId -> {
                    PostVO postVO = new PostVO();
                    postVO.setPostTitle("테스트 제목1");
                    postVO.setPostContent("테스트 내용1");
                    postVO.setMemberId(memberId);
                    postMapper.insert(postVO);
                });
    }

    @Test
    public void memberInsertTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("qortlgus100@gmail.com");
        memberVO.setMemberPassword("1234");
        memberVO.setMemberName("백시현");

        memberMapper.insert(memberVO);
    }

    @Test
    public void memberDeleteTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("qortlgus100@gmail.com");
        memberVO.setMemberPassword("1234");
        memberMapper.select(memberVO).map(MemberVO::getId)
                .ifPresent(memberMapper::delete);
    }

    @Test
    public void memberSelectTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("qortlgus100@gmail.com");
        memberVO.setMemberPassword("1234");
        memberMapper.select(memberVO).map(MemberVO::toString)
                .ifPresentOrElse(log::info, () -> {
                    log.info("로그인 실패");
                });
    }
}
