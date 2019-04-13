package com.test.web.controller;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
// 自动加载 Spring Boot 容器
@SpringBootTest
public class TestReply {
    private MockMvc mockMvc;
    // 表示在测试启动的时候先执行一次，一般用作资源初始化。
    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new ReplyController()).build();
    }
    @Test
    public void getReply() throws Exception {
        // .accept(MediaType.APPLICATION_JSON_UTF8))  设置 JSON 返回编码，避免出现中⽂文乱码的问题。
        // print() 方法将请求和相应的过程都打印出来
        mockMvc.perform(MockMvcRequestBuilders.post("/reply?name=小明")
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
        // MockMvcResultMatchers.content()：获取到 Web 请求执行后的结果
        // Matchers.containsString：判断返回的结果集中是否包含指定的字符串
        mockMvc.perform(MockMvcRequestBuilders.post("/reply?name=小明")
                .accept(MediaType.APPLICATION_JSON_UTF8)).andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("小明")));
    }
}
