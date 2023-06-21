package boardProject.MainBoard.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import static boardProject.MainBoard.domain.Status.allow;

@Getter
@Setter
public class User {
    private String userName;
    static protected Long userCount= 0L;
     private  Long userCode;
    private  String id;
    private  String password;
    private  String nickName;
    private List<String> blockUserList;
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
        blockUserList= new ArrayList<>();
    }
    public void addBlock(User user){
        blockUserList.add(user.getId());
    }
    public void deleteBlock(User user){
        blockUserList.remove(user.getId());
    }
}
