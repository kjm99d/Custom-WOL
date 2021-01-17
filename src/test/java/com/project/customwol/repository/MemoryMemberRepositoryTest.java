package com.project.customwol.repository;

import com.project.customwol.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 한번 테스트마다 저장소 비우기
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setId("Test");
        member.setPassword("Test2");

        repository.save(member);
        Member result = repository.findById(member.getPk()).get();

    }

}
