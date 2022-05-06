package br.com.vemprafam.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vemprafam.dao.DaoFuncionario;
import br.com.vemprafam.pojo.Funcionario;

public class LogicaAlterar implements Logica {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		int re = Integer.parseInt(request.getParameter("re"));
		DaoFuncionario dao = new DaoFuncionario();
		Funcionario funcionario = dao.buscarPeloRe(re);
		request.setAttribute("funcionario", funcionario);
		return "/alteracao.jsp";
	}

}
