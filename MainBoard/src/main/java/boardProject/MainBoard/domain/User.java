package boardProject.MainBoard.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import static boardProject.MainBoard.domain.Status.allow;

@Entity
@Getter
@Setter
public class User {


    private String userName;
    static protected Long userCount= 0L;
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
     private  Long userCode;

    private  String id;
    private  String password;
    private  String nickName;
    private Authority authority;
    private Status status;
    static protected String managerCode="power";
    public User(String userName, String id, String password, String nickName) {
        this.userName = userName;
        this.userCode = userCount;
        userCount++;
        this.id = id;
        this.password = password;
        this.nickName = nickName;
        this.authority = Authority.user;
        this.status = allow;
    }

}
