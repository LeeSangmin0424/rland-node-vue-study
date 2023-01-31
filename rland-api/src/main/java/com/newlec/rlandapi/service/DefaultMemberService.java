package com.newlec.rlandapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newlec.rlandapi.entity.Member;
import com.newlec.rlandapi.repository.MemberRepository;

@Service
public class DefaultMemberService implements MemberService {

    @Autowired
    private MemberRepository repository;

    @Override
    public Member get(String username) {
        System.out.println("멤버!!!!!!!!!!!!!!"+username);
        
        Member member = repository.findByUsername(username);
        System.out.println("멤버!!"+member);
        System.out.println("서비스 username!!"+username);

        return member;
    }
    
}
