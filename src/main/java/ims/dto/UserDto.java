package ims.dto;

import ims.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

    private String userId;
    private String name;
    private String password;

    public UserDto (String userId, String name, String password) {
        super();
        this.userId = userId;
        this.name = name;
        this.password = password;
    }

    public User _toUser(){
        return new User(this.userId, this.name, this.password);
    }

}
