package com.example.ChatApp.controller;


import com.example.ChatApp.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.broker.SimpleBrokerMessageHandler;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
public class ChatController {
    @MessageMapping("message")
    @SendTo("/chat/messages")

    public ChatMessage sendMessage(@Payload ChatMessage chatMessage){

        try{
        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8080/Chat","root", "");
        Statement st = con.createStatement();

        st.executeUpdate("INSERT INTO message (CONTENT, USER)\n" + "VALUES ('"+chatMessage.getContent()+"','"+chatMessage.getSender()+"');");
        con.close();
    }
        catch (SQLException ex) {

        System.out.println("SQL Exception : "+ ex.getMessage());

        System.out.println("Vendor Error : "+ ex.getErrorCode());

    }
        catch(ClassNotFoundException ex) {

        ex.printStackTrace();

    }
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/chat/messages")

    public ChatMessage addUser (@Payload ChatMessage chatMessage,
                                SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
}
