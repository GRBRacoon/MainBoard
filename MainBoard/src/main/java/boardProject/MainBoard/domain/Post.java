package boardProject.MainBoard.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post extends Writing {
    private Long postCode;
    static protected Long postCount= 0L;
    private Tag tag;
    private PostTag postTag;



    public Post(int date,String name,String data,String userId,Tag tag, PostTag postTag) {
        this.setDate(date);
        this.setName(name);
        this.setStatus(Status.allow);
        this.setData(data);
        this.setUserId(userId);
        this.setLike(0);

        this.postCode =postCount;
        postCount++;
        this.tag = tag;
        this.postTag = postTag;
    }
}
