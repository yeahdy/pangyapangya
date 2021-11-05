package com.example.pangyapangya.mappers;

import com.example.pangyapangya.beans.vo.ClassReplyVO;
import com.example.pangyapangya.beans.vo.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ClassReplyMapper {
    //    댓글 등록
    public int insert(ClassReplyVO classReplyVO);
    //    댓글 1개 조회
    public ClassReplyVO read(Long rno);

//    //    댓글 삭제
//    public int delete(Long rno);
//    //    댓글 수정
//    public int update(ClassReplyVO classReplyVO );
    //    댓글 목록
//    기존의 게시글 페이징 처리 + 특정 게시글 번호를 전달해야 한다.
//    MyBatis는 두 개 이상의 데이터를 파라미터로 전달받아서 사용할 수 없다.
//    별도의 객체로 구성하거나 Map을 이용하여 구성한다.
//    하지만 위 2가지 방법이 적합하지 않다면, KEY값을 어노테이션으로 부여하고,
//    @Param("key")이라고 작성한다.

    public List<ClassReplyVO> getListWithPaging(@Param("bno") Long bno, @Param("criteria") Criteria criteria);

    //    댓글 개수
    public int getTotal(Long bno);
}
