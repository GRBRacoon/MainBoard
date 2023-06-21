package boardProject.MainBoard.service;

import boardProject.MainBoard.domain.Authority;
import boardProject.MainBoard.domain.Status;
import boardProject.MainBoard.domain.User;
import boardProject.MainBoard.repository.UserRepository;

import java.util.List;


public class UserService {
    UserRepository userRepository=new UserRepository();

    public void join(User user){
        userRepository.save(user);
    }

    public boolean userExist(String id){
        boolean b= userRepository.idCheck(id);
        return b;
    }
    public void setStatus(User user,Status status){
        userRepository.setStatus(user,status);
    }
    public void setAuthority(User user, Authority authority){
        userRepository.userSetAuthority(user,authority);
    }

    public void addBlock(User user){
        userRepository.addBlocked(user);
    }
    public void deleteBlock(User user){
        userRepository.deleteBlocked(user);
    }

    public List blockedUsers(){
        List<User> blocked= userRepository.blockedUser();
        return blocked;
    }



}
