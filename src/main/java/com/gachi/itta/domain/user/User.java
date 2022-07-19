package com.gachi.itta.domain.user;

import com.gachi.itta.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자 모델
 */
@Entity
@Getter
@NoArgsConstructor
public class User extends BaseTimeEntity {
    /**
     * 사용자 고유 식별자
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    /**
     * 사용자 이름
     */
    @Column(nullable = false)
    private String name;
    /**
     * 사용자 이메일
     */
    @Column(nullable = false)
    private String email;
    /**
     * 사용자 프로필 사진
     */
    @Column
    private String picture;
    /**
     * 사용자 방 참여 목록
     */
    @OneToMany(mappedBy = "user")
    private List<Attend> attends = new ArrayList<>();

    /**
     * 사용자 생성
     *
     * @param name    회원 이름
     * @param email   회원 이메일
     * @param picture 회원 프로필 사진
     */
    @Builder
    public User(String name, String email, String picture) {
        this.name = name;
        this.email = email;
        this.picture = picture;
    }
}
