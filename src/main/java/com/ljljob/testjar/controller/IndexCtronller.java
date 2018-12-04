package com.ljljob.testjar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * 描述:
 * IndexCtronller
 *
 * @author JimWu
 * @create 2018-12-04 11:14
 */
@Controller
public class IndexCtronller {

    @RequestMapping("index")
    public String index(HttpServletRequest request, Model model) {
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String serverIp=addr.getHostAddress().toString(); //获取本机ip
        String serverName=addr.getHostName().toString(); //获取本机计算机名称
        String clientIp = request.getRemoteAddr();
        String currentTime = new Date().toLocaleString();
        model.addAttribute("serverIp", serverIp);
        model.addAttribute("serverName", serverName);
        model.addAttribute("clientIp", clientIp);
        model.addAttribute("currentTime", currentTime);
        return "index";
    }
}