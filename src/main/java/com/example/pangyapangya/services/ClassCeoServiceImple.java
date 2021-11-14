package com.example.pangyapangya.services;


import com.example.pangyapangya.beans.dao.BakeryFileDAO;
import com.example.pangyapangya.beans.dao.CEODAO;
import com.example.pangyapangya.beans.dao.ClassCeoDAO;
import com.example.pangyapangya.beans.dao.ClassCeoFileDAO;
import com.example.pangyapangya.beans.vo.CeoVO;
import com.example.pangyapangya.beans.vo.ClassCeoFileVO;
import com.example.pangyapangya.beans.vo.ClassCeoVO;
import com.example.pangyapangya.beans.vo.Criteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//    비지니스 계층
//    프레젠테이션 계층(View)와 영속 계층(DBMS)의 중간다리 역할을 한다.
//    영속 계층은 DBMS를 기준으로, 비지니스 계층은 로직을 기준으로 처리한다.
//    예를 들어 쇼핑몰에서 상품 구매 시 포인트 적립을 한다고 가정한다면,
//    영속 계층의 설계는 '상품', '회원'으로 나누어 설계하지만 비지니스 계층은
//    상품 영역과 회원 영역을 동시에 사용해서 하나의 로직을 처리하게 된다.

//    일반적으로 비지니스 영역에 있는 객체들은 서비스(Service)라는 용어를 많이 사용한다.

@Service
@RequiredArgsConstructor
public class ClassCeoServiceImple implements ClassCeoService{

    private final ClassCeoDAO classCeoDAO;
    private final ClassCeoFileDAO classCeoFileDAO;
    private final CEODAO ceodao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void register(ClassCeoVO classCeoVO) {

        classCeoDAO.register(classCeoVO);
        if(classCeoVO.getAttachList() == null || classCeoVO.getAttachList().size() == 0){
            return;
        }

        classCeoVO.getAttachList().forEach(attach -> {
            attach.setBno(classCeoVO.getBno());
            classCeoFileDAO.insert(attach);
        });
    }

    @Override
    public ClassCeoVO get(Long bno) {
        return classCeoDAO.get(bno);
    }

    @Override
    public boolean modify(ClassCeoVO classCeoVO) {
        return classCeoDAO.modify(classCeoVO);
    }

    @Override
    public boolean remove(Long bno) {
        return classCeoDAO.remove(bno);
    }

    @Override
    public List<ClassCeoVO> getList(Criteria criteria) { return classCeoDAO.getList(criteria); }

    @Override
    public List<ClassCeoVO> getAllList() {return classCeoDAO.getAllList();}

    @Override
    public int getTotal(Criteria criteria) { return classCeoDAO.getTotal(criteria); }
    @Override
    public int myTotal(String ceoId) { return classCeoDAO.myTotal(ceoId); }

    @Override
    public CeoVO getCeo(String ceoId) { return ceodao.ceoInfo(ceoId); }

    /* @Override
    public List<BakeryFileVO> getAttachList(Long bno) {
        return bakeryFileDAO.findByBno(bno);
    }*/


    // 메인페이지 글 가져오기
    public List<ClassCeoVO> classList_main() { return  classCeoDAO.classList_main(); }
    @Override
    public List<ClassCeoFileVO> getAttachList(Long bno) {
        return classCeoFileDAO.findByBno(bno);
    }

}
