package br.com.zup.marvel.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.zup.marvel.Service.ClienteService;
import br.com.zup.marvel.entity.Cliente;

@WebServlet("/cliente/*")
public class ClienteController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private Gson gson = new Gson();
	ClienteService clienteService = new ClienteService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cliente clienteResponseCliente = clienteService.insereCliente(transformaJsomEmStringCliente(req));
		
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        String clienteJsonString = this.gson.toJson(clienteResponseCliente);
        out.print(clienteJsonString);
        out.flush();   
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String cpf = req.getParameter("cpf");
		List<Cliente> listaDecliente = clienteService.retornaClientes(cpf);
		String clienteJsonString = this.gson.toJson(listaDecliente);
		
		PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(clienteJsonString);
        out.flush();   
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cpf = recuperaPathParameterToString(req);
		Cliente cliente = transformaJsomEmStringCliente(req);
		cliente.setCpf(cpf);
		Cliente clienteResponse = clienteService.atualizaCliente(cliente, cpf);
		
		String clienteJsonString = gson.toJson(clienteResponse);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		out.print(clienteJsonString);
		out.flush();
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cpf = recuperaPathParameterToString(req);
		
		clienteService.deleta(cpf);
	}

	private Cliente transformaJsomEmStringCliente(HttpServletRequest req) throws IOException {
		String json = req.getReader().lines().collect(Collectors.joining());
		Gson gson = new Gson();
		Cliente clienteRequest = gson.fromJson(json, Cliente.class);
		return clienteRequest;
	}
	
	private String recuperaPathParameterToString(HttpServletRequest req) {
		String uri = req.getRequestURI();
		int indexParam = uri.lastIndexOf("/");

		String cpf = uri.substring(indexParam + 1);
		return cpf;
	}

}
