package com.gachi.itta.config.auth.dto;

import com.gachi.itta.domain.user.Role;
import com.gachi.itta.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

/**
 * OAuth2User 모델 정보과 관련 기능을 제공합니다.
 */
@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes,
                           String nameAttributeKey, String name,
                           String email, String picture) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    /**
     * OAuth2User에서 반환하는 사용자 정보를 변환합니다.
     *
     * @param registraionId
     * @param userNameAttribuName
     * @param attributes
     * @return
     */
    public static OAuthAttributes of(String registraionId,
                                     String userNameAttribuName,
                                     Map<String, Object> attributes) {
        return ofGoogle(userNameAttribuName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttribuName,
                                            Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttribuName)
                .build();
    }

    /**
     * 사용자 모델을 생성합니다.
     * 처음 가입할 때 사용합니다.
     * 기본 권한을 GUEST로 지정합니다.
     *
     * @return
     */
    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.GUEST)
                .build();
    }
}
