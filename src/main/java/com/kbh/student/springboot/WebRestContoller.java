package com.kbh.student.springboot;


import com.kbh.student.springboot.domain.posts.PostsRepository;
import com.kbh.student.springboot.domain.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class WebRestContoller {


    PostsRepository postsRepository;

    @GetMapping("/")
    public String main(){
        return "gellowwold";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hellow_world";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        postsRepository.save(dto.toEntity());

    }
}
