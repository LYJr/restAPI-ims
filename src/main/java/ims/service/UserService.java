package ims.service;

import ims.domain.User;
import ims.domain.UserRepository;
import ims.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public User findByUserId(String userId){
        return userRepository.findByUserId(userId);
    }

    public User findById(Long id){
        //if문으로 들어온값 비교 후에 넘겨라.
        return userRepository.findById(id).orElseThrow(null);
    }


}
