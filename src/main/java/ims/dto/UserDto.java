package ims.dto;

import ims.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
public class UserDto {

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    public UserDto(String name, String password){
        this.name = name;
        this.password = password;
    }

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
