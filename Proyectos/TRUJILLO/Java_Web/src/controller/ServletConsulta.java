package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

import controller.ClienteBll;
import entity.Cliente;
import controller.ResponseClient;
import dto.Mensaje;

/**
 * Servlet implementation class ServletConsulta
 */
@WebServlet("/ServletConsulta")
public class ServletConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private ClienteBll clientebll;
     private ResponseClient responseClient;
     @Override
    public void init() throws ServletException {
    	clientebll= new ClienteBll();
        responseClient = new ResponseClient();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConsulta() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) 
			throws ServletException, IOException {
		Mensaje mensaje;
		//Datos
		Cliente cli = new Cliente();
		cli.setNom_cliente(request.getParameter("nomcliente"));
		//Procesar
			List<Cliente> lista;
			try {
				lista = clientebll.ClienteListar(cli.getNom_cliente());
				if(lista.isEmpty()){
					mensaje= new Mensaje(-50, "No hay coincidencias.");
				}
				else{
					Gson gson = new Gson();
					mensaje= new Mensaje(1, gson.toJson(lista)); 
					responseClient.response(request, response, mensaje);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}