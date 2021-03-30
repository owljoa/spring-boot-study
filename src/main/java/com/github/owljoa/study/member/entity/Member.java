package com.github.owljoa.study.member.entity;

import com.github.owljoa.study.team.entity.Team;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;

@Entity
@Table
@Getter
public class Member {

  @Id
  @GeneratedValue
  @Column(name = "member_id")
  private Long memberId;

//  @ManyToOne(fetch = FetchType.EAGER)
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "team_id")
  private Team team;
}
