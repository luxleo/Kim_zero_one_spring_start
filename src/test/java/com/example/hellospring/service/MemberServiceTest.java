package com.example.hellospring.service;

import com.example.hellospring.domain.Member;
import com.example.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository repository;

    @BeforeEach
    public void beforeEach(){
        // Dependency Injection으로 구현
        repository = new MemoryMemberRepository();
        memberService = new MemberService(repository);
    }

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member mem1 = new Member();
        mem1.setName("member1");
        //when
        Long saveId = memberService.join(mem1);
        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(mem1.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복회원_가입(){
        //given
        Member mem1 = new Member();
        mem1.setName("spring");

        Member mem2 = new Member();
        mem2.setName("spring");
        //when
        memberService.join(mem1);
        assertThrows(IllegalStateException.class,()->memberService.join(mem2));
//        try {
//            memberService.join(mem2);
//        } catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
        //than
    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}