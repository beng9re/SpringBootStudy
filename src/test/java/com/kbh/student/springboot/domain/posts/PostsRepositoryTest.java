package com.kbh.student.springboot.domain.posts;

import org.junit.After;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;


    @After
    public void cleanup(){
        postsRepository.deleteAll();

    }

    @Test
    public void 게시글_저장_불러오기(){
        postsRepository.save(Posts.builder()
                                            .title("test")
                                            .author("test")
                                            .content("contest_text")
                                            .build()
        );

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        assertThat(posts.getTitle(), is("test"));
        assertThat(posts.getAuthor(), is("test"));
        assertThat(posts.getContent(), is("contest_text"));
    }


}