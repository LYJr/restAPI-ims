package ims.service;

import ims.BaseTest;
import ims.domain.User;
import ims.domain.UserRepository;
import ims.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest extends BaseTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void login_success() throws Exception {
        UserDto userDto = new UserDto("a", "resian", "1");
        User user = new User("a", "resian", "1");

//        Mockito.when(userRepository.save(userDto._toUser())).thenReturn(Optional.of(user));
//        어디서 왜 에러가 나는지 1도 모르겠다 살려줘라.

        System.out.println(userRepository.findByUserId("a"));

        assertThat(userService.findByUserId(userDto._toUser().getUserId()).equals("a"));
    }
}