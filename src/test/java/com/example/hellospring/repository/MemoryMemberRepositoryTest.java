package com.example.hellospring.repository;

import com.example.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    //메 테스트 케이스 끝나고 나서 실행 되는 함수
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }
    @Test
    public void save(){
        Member member = new Member();
        member.setName("dragon");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        //System.out.println("result: "+ (result == member));
        //Assertions.assertEquals(member,result);
        assertThat(member).isEqualTo(result);
    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(member1).isEqualTo(result);
    }
    @Test
    public void findAll(){
        Member mem1 = new Member();
        mem1.setName("spring1");
        repository.save(mem1);

        Member mem2 = new Member();
        mem1.setName("spring2");
        repository.save(mem2);

        List<Member> results = repository.findAll();
        assertThat(results.size()).isEqualTo(2);

    }
}
