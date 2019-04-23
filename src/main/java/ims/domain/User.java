package ims.domain;

import ims.dto.UserDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table
@NoArgsConstructor
public class User extends AbstractEntity {
    //size 걸어두기 //컬럼 확인
    private String userId;
    private String name;
    private String password;

    public User(String userId, String name, String password){
        super();
        this.userId = userId;
        this.name = name;
        this.password = password;
    }

    public UserDto _toUserDto(){
        return new UserDto(this.userId, this.name, this.password);
    }

    public boolean isSamePassword(String password){
        return this.password.equals(password);
    }

    public String updateName(String name){
        if(nullCheck(name)){
            return this.name = name;
        }
        return this.name;
    }

    public String updatePassword(String password){
        if(nullCheck(password)){
            return this.password = password;
        }
        return this.password;
    }

    private boolean nullCheck(String input){
        return input != null;
    }
}