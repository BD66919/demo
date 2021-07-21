package com.how2java;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

@WebServlet(name = "loginServlet", urlPatterns = "/login")  
public class LoginServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  
      throws ServletException, IOException {  
        String name = req.getParameter("name");  
        String password = req.getParameter("password");  
        Subject subject = SecurityUtils.getSubject();//全局对象通过安全管理者生成Subject主体对象 ，即用户
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);  //封装输入用户的数据
        try {  
            subject.login(token);//此处调用doGetAuthenticationInfo登录方法
            Session session=subject.getSession();//获取主体会话，即如果当前没有创建Session对象，会创建一个。
            session.setAttribute("subject", subject);//添加会话中的信息           
            resp.sendRedirect("index.jsp");//重定向
        } catch (AuthenticationException e) {  
        	
            req.setAttribute("error", "验证失败");  
            req.getRequestDispatcher("login.jsp").forward(req, resp); //转发
        }  
    }  
}  