package ims.service;

import ims.domain.User;
import ims.domain.UserRepository;
import ims.dto.UserDto;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.Optional;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class UserService {

    // TODO: 2019-04-30 delete html 생성 및 Controller 연결
    // TODO: 2019-04-30 user login check-> 현재 들어온 데이터가 있는지만 확인했음
    // TODO: 2019-04-30 html 중복제거

    @Autowired
    private UserRepository userRepository;

    private static final String SEEEIOND_USER = "user";
    private static final Logger log = getLogger(UserService.class);

    public User save(UserDto userDto){
        return userRepository.save(userDto._toUser());
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findByUserId(String userId){
        return userRepository.findByUserId(userId);
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(null);
    }

    public boolean login(String userId, String password) {
        Optional<User> maybeUser = findByUserId(userId);
        return maybeUser.isPresent() && maybeUser.get().isSamePassword(password);
    }

    public User update(@PathVariable Long id, UserDto updateUser) {
        User originUser = findById(id);
        originUser.updateName(updateUser.getName());
        originUser.updatePassword(updateUser.getPassword());

       return userRepository.save(originUser);
    }

    public void logout(HttpSession session) {
        session.removeAttribute(SEEEIOND_USER);
    }

    public boolean delete(String userId, String password) {
        Optional<User> maybeUser = findByUserId(userId);
        if(maybeUser.isPresent()){
            return maybeUser.get().deleteCheck(password);
        }
        return false;
    }

    public boolean loginCheck(HttpSession session) {
        Object sessionUser = session.getAttribute(SEEEIOND_USER);
        return sessionUser != null;
    }

}
