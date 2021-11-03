//package com.example.pangyapangya.beans.dao;
//
//import com.example.pangyapangya.beans.vo.ClassReviewFileVO;
//import com.example.pangyapangya.mappers.ClassReviewFileMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class ClassReviewFileDAO {
//    @Autowired
//    private ClassReviewFileMapper classReviewFileMapper;
//
//    public void insert(ClassReviewFileVO classReviewFileVO){
//        classReviewFileMapper.insert(classReviewFileVO);
//    }
//
////    public void delete(String uuid){
////        classReviewFileMapper.delete(uuid);
////    }
//
//    public List<ClassReviewFileVO> findByBno(Long bno){
//        return classReviewFileMapper.findByBno(bno);
//    }
//
////    public void deleteAll(Long bno){classReviewFileMapper.deleteAll(bno);}
//
//    public List<ClassReviewFileVO> getOldFiles() {return classReviewFileMapper.getOldFiles();}
//}
