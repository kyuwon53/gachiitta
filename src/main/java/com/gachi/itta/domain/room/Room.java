package com.gachi.itta.domain.room;

import com.gachi.itta.domain.BaseTimeEntity;
import com.gachi.itta.domain.user.Attend;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 방 모델
 * 방을 개설할 떄 이름, 설명, 타입(포모도로/스터디), 개설자, 참가자 수가 있어야한다.
 */
@Getter
@NoArgsConstructor
@Entity
public class Room extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long id;
    /**
     * 방 이름
     */
    @Column(nullable = false)
    private String name;
    /**
     * 방 설명
     */
    @Column(length = 500)
    private String description;
    /**
     * 방 타입
     * 포모도로 / 스터디
     */
    @Column(nullable = false)
    private RoomType type;
    /**
     * 방 개설자
     */
    private String owner;
    /**
     * 참가자 수 (제한사항)
     */
    private int participantsCount;
    /**
     * 참여 목록
     */
    @OneToMany(mappedBy = "room")
    private List<Attend> attends = new ArrayList<>();

    @Builder
    public Room(Long id, String name, String description, RoomType type, String owner, int participantsCount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.owner = owner;
        this.participantsCount = participantsCount;
    }
}
