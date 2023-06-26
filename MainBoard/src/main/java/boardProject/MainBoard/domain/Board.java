package boardProject.MainBoard.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Board {
    private List<Post> postList;
    private PostTag postTag;

}
