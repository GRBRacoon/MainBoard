package boardProject.MainBoard.repository;

import boardProject.MainBoard.domain.Authority;
import boardProject.MainBoard.domain.Status;
import boardProject.MainBoard.domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.sql.Update;
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
   // private static Map<String, User> storage=new HashMap<>();

    public void save(User user){
        em.persist(user);
    }
    public User findUser(String id){
        User user=em.find(User.class,id);
        return user;
    }

    public void setStatus(User user,Status status){
        User change;
        change=em.find(User.class,user.getId());
        change.setStatus(status);
        em.persist(change);
    }
    public User userSetAuthority( User user, Authority authority){
        User change = em.find(User.class, user.getId());
        change.setAuthority(authority);
        Query query = em.createQuery("UPDATE User u SET u.authority = :authority WHERE u.id = :id");
        query.setParameter("authority", change.getAuthority());
        query.setParameter("id", change.getId());
        query.executeUpdate();

        return user;
    }

}
