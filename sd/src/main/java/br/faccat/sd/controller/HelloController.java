/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.faccat.sd.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            HttpServletResponse res) {

        StringBuilder sb = new StringBuilder();

        if (nome == null || "".equals(nome)) {
            sb.append("&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;Hello World");
        } else {
            sb.append("&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;Seja bem vindo ").append(nome);
        }

        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            System.out.println(ex.getMessage());
            sb.append("&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;Docker ").append(ex.getMessage().substring(0, 12));
        }

        return sb.toString();
    }
}
