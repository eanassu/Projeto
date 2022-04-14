package br.com.vemprafam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vemprafam.dao.DaoFuncionario;
import br.com.vemprafam.pojo.Funcionario;

/**
 * Servlet implementation class ServletFuncionarios
 */
@WebServlet("/Funcionarios")
public class ServletFuncionarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFuncionarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		DaoFuncionario dao = new DaoFuncionario();
		List<Funcionario> funcionarios = dao.getFuncionarios();
		out.print("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset='ISO-8859-1'>\r\n"
				+ "<title>Funcionários</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<table border='1'>\r\n"
				+ "<tr>\r\n"
				+ "<th>RE</th><th>nome</th><th>salário</th><th>nascimento</th>\r\n"
				+ "</tr>\r\n");
		for( Funcionario funcionario: funcionarios ) {
			out.format("<tr><td>%d</td><td>"+funcionario.getNome()+
					"</td><td>%.2f</td><td>"+
					funcionario.getDataNascimento()+
					"</td></tr>",funcionario.getRe(),
					funcionario.getSalario());
		}
		out.print("</table>\r\n"
				+ "<a href=\"/Projeto\">voltar</a>"
				+ "</body>\r\n"
				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
