package ims.web;

import ims.domain.User;
import ims.dto.UserDto;
import ims.exception.ImsUncheckedException;
import ims.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import java.util.Optional;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
@RequestMapping("/users")
public class UserController {
    private static final Logger log = getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("")
    public String create(UserDto userDto){
        userService.save(userDto);
        return "/index";
    }

    @PostMapping("/login")
    public String login(String userId, String password, HttpSession session) throws ImsUncheckedException {
        if(!userService.login(userId, password)){
            throw new ImsUncheckedException("아이디나 비밀번호가 잘못되었습니다.");
        }

        Optional<User> maybeUser = userService.findByUserId(userId);
        User user = maybeUser.orElseThrow(null);

        log.debug("user확인:{}",user);
        //리팩토링 가능할 것 같은데 흠..
        session.setAttribute("user", user);
        //session에 userId에 해당하는 데이터를 담음

        return "redirect:/";
    }

    @GetMapping("/{id}/form")
    //url에서 파라미터 id를 호출하는 방식인 pathVariable
    public String update(@PathVariable Long id, HttpSession session ,Model model){
        if(!userService.loginCheck(session)){
            return "redirect:/users/login";
        }

        User user = userService.findByUserId(((User) session.getAttribute("user")).getUserId()).orElseThrow(null);

        log.debug("user:{}", user);

        model.addAttribute("users", user);
        return "/user/updateForm";
    }

    @PutMapping("/{id}/updateForm")
    public String updateForm(@PathVariable Long id, UserDto updateUser, HttpSession session) throws ImsUncheckedException{
        //session에 값 다시 넣어야하나? 'ㅍ'?
        //동일 사용자 check 나중에 생각하기

        userService.update(id, updateUser);
        return "redirect:/";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
//        userService.logout(session);

        return "redirect:/";
    }


}
