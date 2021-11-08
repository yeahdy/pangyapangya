package com.example.pangyapangya.services;

import com.example.pangyapangya.beans.dao.BreadDetailDAO;
import com.example.pangyapangya.beans.vo.BakeryVO;
import com.example.pangyapangya.beans.vo.BreadReviewVO;
import com.example.pangyapangya.beans.vo.Criteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BreadDetailServiceImple implements BreadDetailService{

    private final BreadDetailDAO breadDetailDAO;

    @Override
    public BakeryVO getInfo(Long bno){
        return breadDetailDAO.get(bno);
    }

/*    @Override
    public BreadReviewVO getReply(Long bno) {
        return breadDetailDAO.read(bno);
    }*/


    @Override
    public List<BreadReviewVO> getListWithPaging(Long bno, Criteria criteria) {
        return breadDetailDAO.getListWithPaging(bno, criteria);
    }


/*    public BakeryVO getInfo(Long bno){return breadDetailDAO.get(bno);}

    public BreadReviewVO getReply(Long bno){ return breadDetailDAO.read(bno);}

    public List<BakeryVO> getList(Criteria criteria) { return breadDetailDAO.getList(Long bno); }

    public List<BreadReviewVO> replyList(){ return breadDetailDAO.getList(); }*/

}
