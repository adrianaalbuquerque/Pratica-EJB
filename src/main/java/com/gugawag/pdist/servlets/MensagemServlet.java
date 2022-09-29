package com.gugawag.pdist.servlets;

import com.gugawag.pdist.ejbs.MensagemService;
import com.gugawag.pdist.model.Mensagem;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = {"/mensagem.do"})
public class MensagemServlet extends HttpServlet {

    @EJB(lookup = "java:module/mensagemService")
    private MensagemService mensagemService;

    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String operation = req.getParameter("operacao");
        PrintWriter answer = resp.getWriter();

        switch (operation) {
            case "1": {
                long id = Integer.parseInt(req.getParameter("id"));
                String texto = req.getParameter("texto");
                mensagemService.inserir(id, texto);
                break;
            }
            case "2": {
                for (Mensagem m: mensagemService.listar()) {
                    answer.println(m.getTexto());
                }
                break;
            }
            case "3":{
                answer.println(mensagemService.pesquisar(Integer.parseInt(req.getParameter("idPesq"))));
                break;
            }
        }
    }
}
