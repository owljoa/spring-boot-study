package com.github.owljoa.study.member;


import static org.assertj.core.api.Assertions.assertThat;

import com.github.owljoa.study.member.entity.Member;
import com.github.owljoa.study.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class MemberRepositoryTest {

  @Autowired
  private MemberRepository memberRepository;

  @Test
  public void getMember() {
    final Member member = memberRepository.findById(1L).get();
    System.out.println("====================================");
    System.out.println("member's team: " + member.getTeam());
//    assertThat(member.getMemberId()).isNotNull().isEqualTo(1L);
  }

}
