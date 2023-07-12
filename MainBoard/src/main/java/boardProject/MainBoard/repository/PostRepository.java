package boardProject.MainBoard.repository;

import boardProject.MainBoard.domain.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PostRepository {

    EntityManager em;

    public void save(PostTag tag,Post post){
        em.persist(post);
    }


    public List searchByPostTag(PostTag postTag){
        String key =postTag.toString();
        String jpql = "SELECT e FROM Entity e WHERE e.key = :key " +
                "GROUP BY e.key " +
                "HAVING COUNT(e) > 1";

        List<Post> list = em.createQuery(jpql, Post.class)
                .setParameter("key", key)
                .getResultList();
        return list;
    }
    public List searchAll(){
        List<Post> list=em.createQuery("select * from Post").getResultList();
        return list;
    }
    public List searchByUserId(List<Post> list,String userId){

        for (int i=0;i< list.size();i++) {
            Post write =list.get(i);
            if(write.getStatus()== Status.allow&&write.getUserId()==userId){
                list.add(write);
            }
        }
        return list;
    }
    public List searchByName(List<Post> list,String name){

        for (int i=0;i< list.size();i++) {
            Post write =list.get(i);
            if(write.getStatus()== Status.allow&&write.getName().contains(name)){
                list.add(write);
            }
        }
        return list;
    }
    public List searchByDate(List<Post> list,int date1, int date2){

        for (int i=0;i< list.size();i++) {
            Post write =list.get(i);
            if(write.getStatus()== Status.allow){
                if(write.getDate()<=date1&&write.getDate()>=date2)
                list.add(write);
            }
        }
        return list;
    }
    public List searchByData(List<Post> list,String data){

        for (int i=0;i< list.size();i++) {
            Post write =list.get(i);
            if(write.getStatus()== Status.allow&&write.getData().contains(data)){
                list.add(write);
            }
        }
        return list;
    }
    public Post searchByPostCode(Long code){
        Post post;
        post=em.find(Post.class,code);
       return post;
    }
    public List searchByTag(List<Post> list, Tag tag){

        for (int i=0;i< list.size();i++) {
            Post write =list.get(i);
            if(write.getStatus()== Status.allow&&write.getTag()==tag){
                list.add(write);
            }
        }
        return list;
    }

}
