package com.project.customwol.repository;

import com.project.customwol.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long pk);
    List<Member> findAll();
}
