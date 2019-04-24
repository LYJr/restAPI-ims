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
    public String login(String userId, String password, HttpSession session, Model model) throws ImsUncheckedException {

        if(!userService.login(userId, password)){
            throw new ImsUncheckedException("아이디나 비밀번호가 잘못되었습니다.");
        }

        session.setAttribute("user", userService.findByUserId(userId));
        //session에 userId에 해당하는 데이터를 담음

        return "/index";
    }

    @GetMapping("/{id}")
    //url에서 파라미터 id를 호출하는 방식인 pathVariable
    public String update(@PathVariable Long id, Model model, HttpSession session){


        model.addAttribute("users", userService.findById(id));
    }
}
