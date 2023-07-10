package boardProject.MainBoard.service;

import boardProject.MainBoard.domain.Authority;
import boardProject.MainBoard.domain.Status;
import boardProject.MainBoard.domain.User;
import boardProject.MainBoard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    public final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public void join(User user){
        userRepository.save(user);
    }


    public void setStatus(User user,Status status){
        userRepository.setStatus(user,status);
    }
    public void setAuthority(User user, Authority authority) {
        userRepository.userSetAuthority(user, authority);
    }
}
