/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.faccat.sd.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rodrigo
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    String getHello(@RequestParam(defaultValue = "", required = false) String nome,
            HttpServletRequest req,
            HttpServletResponse res) throws UnknownHostException, IOException {

        StringBuilder sb = new StringBuilder();

        //InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("AQIII");
       // sb.append("&nbsp;Docker Address:- ").append(inetAddress.getHostAddress());
        sb.append("&nbsp;Docker Address:- ").append(Runtime.getRuntime().exec("hostname"));
        if (nome == null || "".equals(nome) ) {
            sb.append("&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;Hello World");
        } else {
            sb.append("&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;Seja bem vindo ").append(nome);
        }

        return sb.toString();
    }
}
