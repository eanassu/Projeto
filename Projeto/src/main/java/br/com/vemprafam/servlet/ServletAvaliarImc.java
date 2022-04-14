package br.com.vemprafam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAvaliarImc
 */
@WebServlet("/AvaliarImc")
public class ServletAvaliarImc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAvaliarImc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double peso = Double.parseDouble(request.getParameter("peso"));
		double altura = Double.parseDouble(request.getParameter("altura"));
		double imc = peso/(altura*altura);
		PrintWriter out = response.getWriter();
		out.printf("IMC = %.2f%n", imc);
		if( imc < 18.5 ) {
			out.println("baixo");
		} else if ( imc < 25 ) {
			out.println("normal");
		} else {
			out.println("alto");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
