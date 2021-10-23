package com.github.owljoa.study.member.service;

import com.github.owljoa.study.member.entity.Member;
import com.github.owljoa.study.member.repository.MemberRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  public List<Member> getAllMember() {
    return memberRepository.findAll();
  }
}
