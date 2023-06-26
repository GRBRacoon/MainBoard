package boardProject.MainBoard.repository;

import boardProject.MainBoard.domain.Authority;
import boardProject.MainBoard.domain.Status;
import boardProject.MainBoard.domain.User;
import jakarta.persistence.EntityManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;

@Repository
public class UserRepository {
    private final EntityManager em;


    //db 커넥션 끝나면 닫기
    //finally(close(conn,pstmt,rs)

    public  UserRepository(EntityManager em){
        this.em=em;
    }
    private static Map<String, User> storage=new HashMap<>();

    public void save(User user){
        em.persist(user);
    }
    public User findUser(String id){
        User user=em.find(User.class,id);
        return user;
    }

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
