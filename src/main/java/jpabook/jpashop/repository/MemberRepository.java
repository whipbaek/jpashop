package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    // @PersistenceContext (springboot 에서는 생성자 주입으로도 가능하게 도와줌, 정석은 persistent 어노테이션 사용)
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    } //(type, PK)

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class) //jpql 은 entity 객체를 통해 쿼리문을 날림(sql 은 테이블기준)
                .getResultList();
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name",name)
                .getResultList();
    }
}
