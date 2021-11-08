package com.example.pangyapangya.services;


import com.example.pangyapangya.beans.dao.BakeryDAO;
import com.example.pangyapangya.beans.dao.BakeryFileDAO;
import com.example.pangyapangya.beans.dao.CEODAO;
import com.example.pangyapangya.beans.vo.BakeryFileVO;
import com.example.pangyapangya.beans.vo.BakeryVO;
import com.example.pangyapangya.beans.vo.CeoVO;
import com.example.pangyapangya.beans.vo.Criteria;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class BakeryServiceImple implements BakeryService{

    private final BakeryDAO bakeryDAO;
    private final BakeryFileDAO bakeryFileDAO;
    private final CEODAO ceodao;
    private final PasswordEncoder passwordEncoder;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void register(BakeryVO bakeryVO) {

        bakeryDAO.register(bakeryVO);
        if(bakeryVO.getAttachList() == null || bakeryVO.getAttachList().size() == 0){
            return;
        }

        bakeryVO.getAttachList().forEach(attach -> {
            attach.setBno(bakeryVO.getBno());
            bakeryFileDAO.insert(attach);
        });
    }

    @Override
    public BakeryVO get(Long bno) {
        return bakeryDAO.get(bno);
    }

    @Override
    public boolean modify(BakeryVO bakeryVO) {
        return bakeryDAO.modify(bakeryVO);
    }

    @Override
    public boolean remove(Long bno) {
        return bakeryDAO.remove(bno);
    }

    @Override
    public List<BakeryVO> getList(Criteria criteria) {
        return bakeryDAO.getList(criteria);
    }

    @Override
    public int getTotal(Criteria criteria) { return bakeryDAO.getTotal(criteria); }

    @Override
    public int myTotal(String ceoId) { return bakeryDAO.myTotal(ceoId); }

    @Override
    public CeoVO getCeo(String ceoId) { return ceodao.ceoInfo(ceoId); }

    @Override
    public boolean ceoUpdate(CeoVO ceoVO) {
        String pw = passwordEncoder.encode(ceoVO.getCeoPw());
        ceoVO.setCeoPw(pw);
        return bakeryDAO.ceoUpdate(ceoVO);
    }

    @Override
    public boolean ceoDelete(CeoVO ceoVO) {
        String pw = passwordEncoder.encode(ceoVO.getCeoPw());
        ceoVO.setCeoPw(pw);
        return bakeryDAO.ceoDelete(ceoVO);
    }

    // 메인페이지 글가져오기
    public List<BakeryVO> breadList_main() { return bakeryDAO.breadList_main(); }

    @Override
    public List<BakeryVO> breadList(String keyword) {
        return bakeryDAO.breadList(keyword);
    }

    @Override
    public List<BakeryVO> breadListCeo(BakeryVO bakeryVO) {
        return bakeryDAO.breadListCeo(bakeryVO);
    }

     @Override
    public List<BakeryFileVO> getAttachList(Long bno) {
        return bakeryFileDAO.findByBno(bno);
    }


}
