package com.example.hellospring.service;

import com.example.hellospring.domain.Member;
import com.example.hellospring.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional //(test후 db에 commit 하지 않아 반영되지 않는다.
class MemberServiceIntegrationTest {
    @Autowired MemberService memberService; // test의 경우 DI 방식을 스태틱 인젝션으로 해도 무방하다 (일회성 이기에)
    @Autowired MemberRepository memberRepository;


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