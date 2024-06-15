package com.springboot.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.lms.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
