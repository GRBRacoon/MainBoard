package boardProject.MainBoard.service;

import boardProject.MainBoard.domain.Comment;
import boardProject.MainBoard.domain.Post;
import boardProject.MainBoard.domain.PostTag;
import boardProject.MainBoard.domain.Tag;
import boardProject.MainBoard.repository.PostRepository;

import java.util.List;

public class PostService {

    PostRepository postRepository=new PostRepository();
    public void addPost(Post post){
        postRepository.save(post.getPostTag(),post);
    }
    public List findByUserId(PostTag postTag, String id){
        List tagList;
        List<Post> list;
        if(postTag==PostTag.all){
            tagList=postRepository.searchAll();
        }
        else {
            tagList = postRepository.searchByPostTag(postTag);
        }
        list=postRepository.searchByUserId(tagList,id);
        return list;
    }
    public List findByName(PostTag postTag, String name){
        List tagList;
        List<Post> list;
        if(postTag==PostTag.all){
            tagList=postRepository.searchAll();
        }
        else {
            tagList = postRepository.searchByPostTag(postTag);
        }
        list=postRepository.searchByName(tagList,name);
        return list;
    }
    public List findBydate(PostTag postTag, int date1,int date2){
        List tagList;
        List<Post> list;
        if(postTag==PostTag.all){
            tagList=postRepository.searchAll();
        }
        else {
            tagList = postRepository.searchByPostTag(postTag);
        }
        list=postRepository.searchByDate(tagList,date1,date2);
        return list;
    }

    public List findByData(PostTag postTag, String data){
        List tagList;
        List<Post> list;
        if(postTag==PostTag.all){
            tagList=postRepository.searchAll();
        }
        else {
            tagList = postRepository.searchByPostTag(postTag);
        }
        list=postRepository.searchByData(tagList,data);
        return list;
    }
    public List findByPostCode(PostTag postTag, Long code){
        List tagList;
        List<Post> list;
        if(postTag==PostTag.all){
            tagList=postRepository.searchAll();
        }
        else {
            tagList = postRepository.searchByPostTag(postTag);
        }
        list=postRepository.searchByPostCode(tagList,code);
        return list;
    }
    public List findByTag(PostTag postTag, Tag tag){
        List tagList;
        List<Post> list;
        if(postTag==PostTag.all){
            tagList=postRepository.searchAll();
        }
        else {
            tagList = postRepository.searchByPostTag(postTag);
        }
        list=postRepository.searchByTag(tagList,tag);
        return list;
    }

}
