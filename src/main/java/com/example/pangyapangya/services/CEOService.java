package com.example.pangyapangya.services;

import com.example.pangyapangya.beans.dao.CEODAO;
import com.example.pangyapangya.beans.vo.CeoVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CEOService {
    private final CEODAO ceoDAO;
    private final PasswordEncoder passwordEncoder;

    // 아이디 중복검사
    public boolean checkIdCEO (String ceoId){
        return ceoDAO.checkIdCEO(ceoId);
    }

    // 회원가입 + 비밀번호 암호화
    public void joinCEO (CeoVO ceoVO){
        if(ceoVO != null){
            // 비밀번호 암호화
            System.out.println("사용자 비밀번호: " + ceoVO.getCeoPw());
            String encodedPw = passwordEncoder.encode(ceoVO.getCeoPw());
            System.out.println("암호화된 비밀번호: " + encodedPw);

            // 암호화된 비밀번호로 저장
            ceoVO.setCeoPw(encodedPw);
            ceoDAO.joinCEO(ceoVO);
        }
    }

    // 로그인
    @Transactional(rollbackFor = Exception.class)
    public boolean loginCEO (CeoVO ceoVO){
        // 사용자가 입력한 아이디 유무 조회
        if(ceoDAO.checkIdCEO(ceoVO.getCeoId())){
            // 저장된 사용자의 정보를 불러옴
            CeoVO ceoInfo = ceoDAO.ceoInfo(ceoVO.getCeoId());
            // 사용자가 입력한 비밀번호와 저장된 사용자의 비밀번호를 비교
            if(!passwordEncoder.matches(ceoVO.getCeoPw(), ceoInfo.getCeoPw())){
                System.out.println("비밀번호가 일치하지 않습니다.");
                return false;
            }else if(ceoInfo.getStatus() == 1){
                System.out.println("이미 탈퇴한 회원입니다.");
                return false;
            }else{
                System.out.println("비밀번호가 일치합니다.");
                ceoDAO.loginCEO(ceoVO);
                return true;
            }
        }else {
            // 해당 아이디가 없을 경우
            System.out.println("해당 아이디 존재하지 않음.");
            return false;
        }
    }

    // 아이디찾기
    public List<CeoVO> idFindCEO (String phoneNum){ return ceoDAO.idFindCEO(phoneNum); }

    // 아이디찾기 갯수
    public int idFindCntCEO (String phoneNum){ return ceoDAO.idFindCntCEO(phoneNum); }

    // 비밀번호 찾기 : 아이디 조회
    public boolean pwFindCEO (String ceoId){ return ceoDAO.pwFindCEO(ceoId); }

    // 비밀번호 찾기: 아이디 + 전화번호 + 이름 같아야 인증 가능
    public boolean pwFindAuthCEO (CeoVO ceoVO) {return ceoDAO.pwFindAuthCEO(ceoVO); }

    // 비밀번호 변경
    public boolean pwUpdateCEO (CeoVO ceoVO) {
        String ceoPw= ceoVO.getCeoPw();

        System.out.print("변경할 비밀번호: " + ceoPw);
        String encodedPw = passwordEncoder.encode(ceoPw);
        System.out.println("암호화된 비밀번호: " + encodedPw);
        // 암호화된 비밀번호로 다시
        ceoVO.setCeoPw(encodedPw);

        return ceoDAO.pwUpdateCEO(ceoVO);
    }

    // 회원정보 조회
    public CeoVO ceoInfo (String ceoId){ return ceoDAO.ceoInfo(ceoId); }
}

