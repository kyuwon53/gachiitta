package com.gachi.itta.domain.user;

import com.gachi.itta.domain.room.Room;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

/**
 * 회원 방 참가 목록
 */
@Entity
@Getter
@NoArgsConstructor
public class Attend {
    /**
     * 참가 목록 고유 식별자
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attend_id")
    private Long id;
    /**
     * 해당 참가 목록 사용자 정보
     */
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    /**
     * 해당 참가 목록 방 정보
     */
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    @Builder
    public Attend(User user, Room room) {
        this.user = user;
        this.room = room;
    }
}
