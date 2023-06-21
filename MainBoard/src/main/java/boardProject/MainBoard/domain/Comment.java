package boardProject.MainBoard.domain;

public class Comment extends Writing{
    private int commentCode;
    static protected int commentCount=0;

    public Comment(int date,String data,String userId) {
        this.setDate(date);
        this.setStatus(Status.allow);
        this.setData(data);
        this.setUserId(userId);
        this.setLike(0);
        this.commentCode =commentCount;
        commentCount++;
    }
}
