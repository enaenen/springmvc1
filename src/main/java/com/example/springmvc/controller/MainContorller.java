package com.example.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
@EnableWebMvc
@Controller
public class MainContorller {
    @Autowired
    /*member 1, member2가 다 bean에 있을경우 어떤 member를 쓸지 모르므로
    * qulifier로 지정*/
    @Qualifier("member2")
    private Member member;

    /*여기에 더이상 do get do post 만들지 않는다. web.xml도 사용하지 않는다.
    * dispatcher servlet이 호출되면*/

    @RequestMapping(value="/hello", method= RequestMethod.GET)
    public String hello() {
        System.out.println("Member="+member.getId());
        return "index";
    }

    @RequestMapping(value="/boards",method=RequestMethod.GET)
        public ModelAndView boardList() {
            List<String> list = new ArrayList<String>();
            list.add("Board 1");
            list.add("Board 2");
            list.add("Board 3");

            ModelAndView mav = new ModelAndView();
            mav.setViewName("/list");
            mav.addObject("boards",list);

            return mav;
        }

    @RequestMapping(value="/boards/{board_id}",method=RequestMethod.GET)
    public ModelAndView boardDetail(@PathVariable("board_id")int board_id) {
        //Board board = dao.selectOne(board_id) DB가 연동되면 이런게 가능

        ModelAndView mav = new ModelAndView();
        mav.setViewName("/detail");
        mav.addObject("board","테스트 게시물 입니다.");

        return mav;
    }
    //localhost:8088/boards?no=10
    //localhost:8088/boards/10

    @RequestMapping("/boards/{no}")
    public String readArticle(@PathVariable("no")int no){
        System.out.println("게시물 상세보기="+no);
        return "read";
    }
    @RequestMapping("/boards/{no}/replay/{rno}")
    public String readReply(@PathVariable("no")int no,
                              @PathVariable("rno")int tno){
        System.out.println("게시물 상세보기="+no);
        System.out.println("댓글" + tno);
        return "TEST";
    }

    @RequestMapping("/members/{member_id}")
    public @ResponseBody Member memberInfo(@PathVariable("member_id") String member_id){
        //Member member = dao.selectOne(member_id);
        System.out.println("member id = "+member_id);

        Member member = new Member("admin","test1234",40);
        return member;
    }


/*    @GetMapping(value="/hello2") //GetMapping 이라는 것 자체가 GET을 호출(위 Request와 같은 의미이다,)
    public String hello2(){
        return "index";
    }*/
    /* POST 도 등록
    @RequestMapping(value="/hello", method= RequestMethod.POST)
    public String hello2(){
        return "Hello, World";

    }*/

}
