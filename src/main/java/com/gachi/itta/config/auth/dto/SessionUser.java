package com.gachi.itta.config.auth.dto;

import com.gachi.itta.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

/**
 * 세션에 저장할 인증된 사용자 정보
 */
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
