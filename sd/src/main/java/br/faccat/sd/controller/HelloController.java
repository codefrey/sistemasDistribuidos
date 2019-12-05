/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.faccat.sd.controller;

import br.faccat.sd.orm.Mensagem;
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
    Mensagem getHello(@RequestParam(defaultValue = "", required = false) String nome,
            HttpServletRequest req,
            HttpServletResponse res) {

        Mensagem m = new Mensagem();

        if (nome == null || "".equals(nome)) {
            m.setMensagem("Hello World");
        } else {
            m.setMensagem("Seja bem vindo " + nome);
        }

        try {
            InetAddress inetAddress = InetAddress.getLocalHost();

            m.setIp(inetAddress.getHostAddress());
            m.setHost(inetAddress.getHostName());

        } catch (UnknownHostException ex) {
            m.setHost(ex.getMessage().substring(0, 12));
        }

        return m;
    }
}
