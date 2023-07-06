package boardProject.MainBoard.repository;

import boardProject.MainBoard.domain.*;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BoardRepository {

    private final EntityManager em;
    public BoardRepository(EntityManager em){
        this.em= em;

    }

    Board board;
    List searchByUserCode(Long userCode){
        List<Post> list=em.createQuery("select m from Post where m.UserCode= :UserCode", Post.class).
                setParameter("UserCode",userCode).getResultList();

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
        return em.createQuery("select m from Post m",Post.class).getResultList();
    }
}
