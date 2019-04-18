package ims.service;

import ims.BaseTest;
import ims.domain.User;
import ims.domain.UserRepository;
import ims.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.booleanThat;
import static org.mockito.Mockito.when;
import static org.slf4j.LoggerFactory.getLogger;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest extends BaseTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private static final Logger log = getLogger(UserServiceTest.class);
    private static UserDto userDto = new UserDto("a", "resian", "1");

    @Test
    public void login_success() throws Exception {
        when(userRepository.findByUserId(userDto._toUser().getUserId())).thenReturn(userDto._toUser());

        assertThat(userService.findByUserId("a")).isEqualTo(userDto._toUser());
//        assertThat(userRepository.findByUserId(userDto._toUser().getUserId()).equals("a"));
    }

    @Test
    public void loignCheck(){
        String userId = "a";

        log.debug("login check:{}", userService.loginCheck(userId));
        assertThat(userService.loginCheck(userId).isEqualTo(true));
    }

    @Test
    public void notLoginCheck(){
        String userId = "메롱";
        log.debug("noLoign:{}", userService.logincheck(userId));
        assertThat(userService.loginCheck(userId)).isEqualTo(false);
    }

    @Test
    public void update(){
        String name = "댕댕";
        String password = "12345";
        //update from

        log.debug("userRepo:{}",userRepository.findByUserId("a"));

        User user = userService.update(name);

        assertThat(user.getName()).isEqualTo(name);
        assertThat(user.getPassword()).isEqualTo(password);
    }
}