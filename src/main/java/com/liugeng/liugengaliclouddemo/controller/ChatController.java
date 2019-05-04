package com.liugeng.liugengaliclouddemo.controller;

import com.liugeng.liugengaliclouddemo.model.weixin.WeixinUserDto;
import com.liugeng.liugengaliclouddemo.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatRoomService chatRoomService;

    @PostMapping("")
    public String publish(@RequestBody WeixinUserDto weixinUserDto) {
        return chatRoomService.publishMsg(weixinUserDto);
    }

    @GetMapping("")
    public List<WeixinUserDto> getMsgListByPage(int start, int end, HttpServletRequest request) {
        return chatRoomService.getMsgListByPage(start, end);
    }
}
