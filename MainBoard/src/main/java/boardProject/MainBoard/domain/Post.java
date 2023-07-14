package boardProject.MainBoard.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Post extends Writing {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postCode;
    static protected Long postCount= 0L;
    private Tag tag;
    private PostTag postTag;



    public Post(int date,String name,String data,String userId,Tag tag, PostTag postTag,String userName) {
        this.setDate(date);
        this.setName(name);
        this.setStatus(Status.allow);
        this.setData(data);
        this.setUserId(userId);
        this.setLike(0);
        this.setUserName(userName);
        this.postCode =postCount;
        postCount++;
        this.tag = tag;
        this.postTag = postTag;
    }
}
