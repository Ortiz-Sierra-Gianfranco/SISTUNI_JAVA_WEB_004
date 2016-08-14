package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Cliente;

@WebServlet("/ServletNewCliente")
public class ServletNewCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletNewCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cli = new Cliente();
		ClienteBll cliB = new ClienteBll();
		cli.setId_cliente("0001");
		cli.setNom_cliente(request.getParameter("nomCli").toUpperCase());
		cli.setDir_cliente(request.getParameter("dirCli").toUpperCase());
		cli.setRucdni_cliente(request.getParameter("dniCli"));
		//cli.setTelefon_cliente(request.getParameter("telCli"));
		cli.setTelefon_cliente(formatoTelefono(request.getParameter("telCli")));
		String destino = null;
		try {
			cliB.ClienteAdicionar(cli);
			destino="Menu.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd;
	    rd = request.getRequestDispatcher(destino);
	    rd.forward(request, response);
		
	}

	private String formatoTelefono(String numero) {
		String[]datos = new String [2];
		String resultado;
		if(numero.length()==7){
		datos[0]=numero.substring(0,3);
		datos[1]=numero.substring(3,7);
		resultado= datos[0]+"-"+datos[1];
		}
		else{
			datos[0]=numero.substring(0,3);
			datos[1]=numero.substring(3,9);
		 resultado= datos[0]+"-"+datos[1];
		}
		return resultado;
	}

}
