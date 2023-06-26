package boardProject.MainBoard.repository;

import boardProject.MainBoard.domain.Board;
import boardProject.MainBoard.domain.Post;
import boardProject.MainBoard.domain.PostTag;
import boardProject.MainBoard.domain.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BoardRepository {

    Map<PostTag,Post> 
    Board board;
    List searchByUserCode(Long userCode){
        List<Post> list=new ArrayList<>();
        for (Post write : board.getPostList()) {
            if(write.getStatus()== Status.allow&&write.getUserCode()==userCode){
                list.add(write);
            }
        }
        return list;
    }
    List searchByName(String name){
        List<Post> list=new ArrayList<>();
        for (Post write :  board.getPostList()) {
            if(write.getStatus()==Status.allow&&write.getName().contains(name)){
                list.add(write);
            }
        }
        return list;
    }
    List searchByDate(int date1, int date2){
        List<Post> list=new ArrayList<>();
        for (Post write :  board.getPostList()) {
            int day= write.getDate();
            if(write.getStatus()==Status.allow) {
                if (day <= date1 && day >= date2) {
                    list.add(write);
                }
            }
        }
        return list;
    }
    List searchByData(String data){
        List<Post> list=new ArrayList<>();
        for (Post write :  board.getPostList()) {
            if(write.getStatus()==Status.allow&&write.getData().contains(data)){
                list.add(write);
            }
        }
        return list;
    }
    List searchByPostTag(PostTag tag){
        List<Post> list =new ArrayList<>();
        for(Post post: board.getPostList()){
            if(post.getStatus()==Status.allow&&post.getPostTag()==tag){
                list.add(post);
            }
        }
        return  list;
    }
    List searchAll(){
        return  board.getPostList();
    }
}
