package br.com.vemprafam.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vemprafam.dao.DaoFuncionario;
import br.com.vemprafam.pojo.Funcionario;

public class LogicaGravar implements Logica{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		int re = Integer.parseInt(request.getParameter("re"));
		String nome = request.getParameter("nome");
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNascimento = new Date();
		try {
			dataNascimento = format.parse(
					request.getParameter("dataNascimento"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		double salario = Double.parseDouble(
				request.getParameter("salario"));
		String email = request.getParameter("email");
		Funcionario funcionario = 
				new Funcionario(re,nome,salario,dataNascimento,email);
		DaoFuncionario dao = new DaoFuncionario();
		dao.alterarFuncionario(funcionario);
		return "/Funcionarios1.jsp";
	}

}
