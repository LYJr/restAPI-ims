package ims.service;

import ims.BaseTest;
import ims.domain.UserRepository;
import ims.dto.UserDto;
import ims.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;

import javax.servlet.http.HttpSession;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
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


    @Before
    public void inputUser() {
        log.debug("실행완료");
        when(userRepository.findByUserId(userDto._toUser().getUserId())).thenReturn(Optional.of(userDto._toUser()));
    }

    @Test
    public void login_success() {
        assertThat(userService.findByUserId("a")).isEqualTo(Optional.of(userDto._toUser()));
//        assertThat(userRepository.findByUserId(userDto._toUser().getUserId()).equals("a"));
    }

    @Test
    public void loignOk() {
        String userId = "a";
        String password = "1";

        assertThat(userService.login(userId, password)).isEqualTo(true);
    }

    @Test
    public void 아이디다름() {
        String userId = "메롱";
        String password = "1";

        assertThat(userService.login(userId, password)).isEqualTo(false);
    }

    @Test
    public void 패스워드다름() {
        String userId = "a";
        String password = "1235";

        assertThat(userService.login(userId, password)).isEqualTo(false);
    }

    @Test
    public void delete(){
        String userId = "a";
        String password = "1";

        assertThat(userService.delete(userId, password)).isEqualTo(true);
    }

    @Test
    public void loginCheck() throws Exception{
        HttpSession session = mock(HttpSession.class);
        Long id = (long)1;

        when(session.getAttribute("users")).thenReturn(Optional.of(userDto._toUser()));
//        assertThat(userService.loginCheck(id, session)).isEqualTo(true);
    }

    //remove는 returon type이 없어서 test가 불가능


}