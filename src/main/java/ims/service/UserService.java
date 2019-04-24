package ims.service;

import ims.domain.User;
import ims.domain.UserRepository;
import ims.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

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

    public Optional<User> update(String userId, String name, String password) {
        Optional<User> maybeUser = findByUserId(userId);
        if(maybeUser.isPresent()){
            maybeUser.get().updateName(name);
            maybeUser.get().updatePassword(password);
        }
        return maybeUser;
    }

    public boolean delete(String userId, String password) {
        Optional<User> maybeUser = findByUserId(userId);
        if(maybeUser.isPresent()){
            return maybeUser.get().deleteCheck(password);
        }
        return false;
    }
}
