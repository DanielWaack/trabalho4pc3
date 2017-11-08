package br.com.prog3.trabalho4;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Preferencia")
public class FormularioServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String nome;
		String matricula;
		int idade;
		String sexo;
		nome = req.getParameter("nome");
		matricula = req.getParameter("matricula");
		idade = Integer.valueOf(req.getParameter("idade"));
		sexo = req.getParameter("sexo");
		out.println("<HTML><HEAD><TITLE>Resposta?");
		out.println("</TITLE></HEAD><BODY>");
		out.println("<br>Nome: " + nome);
		out.println("<br>Matrícula: " + matricula);
		out.println("<br>Idade: " + idade);
		out.println("<br>Sexo: " + sexo + "<br>");
		if (sexo.equals("Feminino")) {
			out.println("<br>Você não precisa servir ao exército.");
		} else if (sexo.equals("Masculino") && idade < 18) {
			out.println("<br>Você está ok com as obrigações militares.");
		} else if (sexo.equals("Masculino") && idade >=18) {
			out.println("<br>Você precisa servir ao exército.");
		}
		out.println("<BR></BODY></HTML>");
		out.close();
	}
}