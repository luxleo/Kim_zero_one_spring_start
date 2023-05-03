package com.example.hellospring.repository;

import com.example.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store= new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(sequence++);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // null 의 가능성이 있어도 가능
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); // 하나라도 만족하는 member 있으면 바로 반환한다.
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // 루프 돌리기 편해서 List 많이 실무에서 사용한다.
    }
    public void clearStore(){
        store.clear();
    }
}
