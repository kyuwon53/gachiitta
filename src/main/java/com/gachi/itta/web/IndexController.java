package com.gachi.itta.web;

import com.gachi.itta.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * 메인 페이지 HTTP 요청을 처리합니다.
 */
@Controller
@RequiredArgsConstructor
public class IndexController {
    private final HttpSession httpSession;

    /**
     * 첫 화면 집입시 세션에 사용자 정보가 있다면 로그인 되어있는 것으로 보고 사용자 정보를 모델로 넘겨줍니다.
     *
     * @param model
     * @return
     */
    @GetMapping("/")
    public String index(Model model) {

        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user != null) {
            model.addAttribute("loginUserName", user.getName());
            model.addAttribute("profileImage", user.getPicture());
        }

        return "index";
    }
}
