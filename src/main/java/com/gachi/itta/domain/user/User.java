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
     * 회원 역할
     * GUEST, USER
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
    /**
     * 사용자 방 참여 목록
     */
    @OneToMany(mappedBy = "user")
    private List<Attend> attends = new ArrayList<>();

    /**
     * 사용자 객체를 생성합니다.
     * @param name
     * @param email
     * @param picture
     * @param role
     */
    @Builder
    public User(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    /**
     * 사용자 권한 key값을 반환합니다.
     * @return
     */
    public String getRoleKey() {
        return this.role.getKey();
    }

    /**
     * 사용자 정보를 업데이트합니다.
     *
     * @param name
     * @param picture
     * @return
     */
    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;
        return this;
    }
}
