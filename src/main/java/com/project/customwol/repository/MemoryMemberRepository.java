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

        return member;
    }

    @Override
    public Optional<Member> findById(String id, String password) {
        List<Member> members = findAll();
        for (Member m: members) {
            String userId = m.getId();
            String userPw = m.getPassword();

            if (userId.equals(id) && userPw.equals(password))  return Optional.ofNullable(store.get(m.getPk()));

        }

        return Optional.ofNullable(store.get(id));
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
