package com.best0167.lol.lolcustomrecord.web;

import com.best0167.lol.lolcustomrecord.config.auth.LoginUser;
import com.best0167.lol.lolcustomrecord.config.auth.dto.SessionUser;
import com.best0167.lol.lolcustomrecord.domain.posts.Posts;
import com.best0167.lol.lolcustomrecord.domain.posts.PostsRepository;
import com.best0167.lol.lolcustomrecord.service.posts.PostsService;
import com.best0167.lol.lolcustomrecord.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());

        if (user == null) {
            return "index";
        }
        model.addAttribute("user", user);
        return "loginHome";
    }



    @GetMapping("/posts/save")
    public String addForm(Model model) {

        Posts posts = new Posts();
        model.addAttribute("posts", posts);
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}
