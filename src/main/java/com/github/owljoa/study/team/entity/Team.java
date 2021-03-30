package com.github.owljoa.study.team.entity;

import com.github.owljoa.study.member.entity.Member;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;

@Entity
@Table
@Getter
public class Team {

  @Id
  @GeneratedValue
  @Column(name = "team_id")
  private Long teamId;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
  private Set<Member> memberSet = new HashSet<>();
}
