package boardProject.MainBoard.repository;

import boardProject.MainBoard.domain.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.*;
import java.util.stream.Collectors;

public class PostRepository {
    MultiValueMap<PostTag,Post> board= new LinkedMultiValueMap<>();


    public void save(PostTag tag,Post post){
        board.add(tag,post);
    }


    public List searchByPostTag(PostTag postTag){
        List<Post> list;
        list=board.get(postTag);
        return list;
    }
    public List searchAll(){
        List<Post> list=new ArrayList<>();
        PostTag[] p=PostTag.values();
        for(int i=0;i<p.length;i++) {
            list.addAll(board.values().stream().toList().get(i));
        }
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
    public List searchByPostCode(List<Post> list,Long code){

        for (int i=0;i< list.size();i++) {
            Post write =list.get(i);
            if(write.getStatus()== Status.allow&&write.getPostCode()==code){
                list.add(write);
            }
        }
        return list;
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
