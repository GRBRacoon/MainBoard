package boardProject.MainBoard.domain;

import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public abstract class Writing {
    private int date;
    private String name;
    private String data;
    private String userId;
    private String userName;
    private List<Comment> commentList;
    private int like;
    private Status status;

    public Comment addComment(Comment comment){
        this.commentList.add(comment);
        return comment;
    }
    public void addLike(){
        like++;
    }
}
