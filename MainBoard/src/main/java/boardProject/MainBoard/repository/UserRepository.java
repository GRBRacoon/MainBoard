package boardProject.MainBoard.repository;

import boardProject.MainBoard.domain.Authority;
import boardProject.MainBoard.domain.Status;
import boardProject.MainBoard.domain.User;
import org.springframework.stereotype.Service;

import java.util.*;


public class UserRepository {
    private static Map<String, User> storage=new HashMap<>();


    public void save(User user){
        storage.put(user.getId(),user);
    }
    public boolean idCheck(String id){
        boolean exist=false;
        if(storage.containsKey(id)){
            exist=true;
        }
        return exist;
    }//해당 아이디가 존재하는지 확인


    public void setStatus(User user,Status status){
        User change= storage.get(user.getId());
        change.setStatus(status);
        storage.replace(change.getId(),change);
    }
    public User userSetAuthority( User user, Authority authority){
        User change= storage.get(user.getId());
        change.setAuthority(authority);
        storage.replace(change.getId(),change);
        return user;
    }
    public void addBlocked(User user){
        User manage=storage.get(user);
        manage.addBlock(user);
        storage.replace(manage.getId(),manage);
    }
    public void deleteBlocked(User user){
        User manage=storage.get(user);
        manage.deleteBlock(user);
        storage.replace(manage.getId(),manage);
    }

    public List blockedUser(){
        List<User> blockList= new ArrayList<>();
        Iterator<String> keys = storage.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            User blocked=storage.get(key);
            if(blocked.getStatus()==Status.block){
                blockList.add(blocked);
            }
        }

        return blockList;
    }
}
