package com.project.customwol.repository;

import com.project.customwol.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setPk(++sequence);
        store.put(member.getPk(), member);
/* 디버깅 메세지
        System.out.println(member.getPk());
        System.out.println(member.getId());
        System.out.println(member.getPassword());

        System.out.println(store.size());
*/

        return member;
    }

    @Override
    public Optional<Member> findById(Long pk) {
        return Optional.ofNullable(store.get(pk));
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
