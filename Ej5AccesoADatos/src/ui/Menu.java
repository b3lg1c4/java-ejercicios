package ui;


import java.util.Scanner;
import java.util.LinkedList;

import data.DataRol;
import entities.*;
import logic.Login;

public class Menu {
	Scanner s=null;
	Login ctrlLogin = new Login();

	public void start() {
		s = new Scanner(System.in);
		Persona p=login();
		System.out.println("Bienvenido "+p.getNombre()+" "+p.getApellido());
		System.out.println();
		
		String command;
		do {
			command=getCommand();
			executeCommand(command);
			System.out.println();
			
		}while(!command.equalsIgnoreCase("exit"));
		
		s.close();
	}

	private void executeCommand(String command) {
		switch (command) {
		case "list":
			System.out.println(ctrlLogin.getAll());
			break;
		case "find":
			System.out.println(find());
			break;
		case "search":
			System.out.println(getByApellido());
			break;
		case "new":
			newUser();
			break;
		case "edit":
			
			break;
		case "delete":
			
			break;
		default:
			break;
		}
	}

	private String getCommand() {
		System.out.println("Ingrese el comando según la opción que desee realizar");
		System.out.println("list\t\tlistar todos");
		System.out.println("find\t\tbuscar por tipo y nro de documento"); //solo debe devolver 1
		System.out.println("search\t\tlistar por apellido"); //puede devolver varios
		System.out.println("new\t\tcrea una nueva persona y asigna un rol existente");
		System.out.println("edit\t\tbusca por tipo y nro de documento y actualiza todos los datos");
		System.out.println("delete\t\tborra por tipo y nro de documento");
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}
	
	public Persona login() {
		Persona p=new Persona();
		
		System.out.print("Email: ");
		p.setEmail(s.nextLine());

		System.out.print("password: ");
		p.setPassword(s.nextLine());
		
		p=ctrlLogin.validate(p);
		
		return p;
		
	}
	
	private Persona find() {
		System.out.println();
		Persona p=new Persona();
		Documento d=new Documento();
		p.setDocumento(d);
		System.out.print("Tipo doc: ");
		d.setTipo(s.nextLine());

		System.out.print("Nro doc: ");
		d.setNro(s.nextLine());
		
		return ctrlLogin.getByDocumento(p);
	}

	private LinkedList<Persona> getByApellido(){

		System.out.println("Ingrese el apellido: ");
		return ctrlLogin.getByApellido(s.nextLine());

	}

	private void newUser(){
		String habilitado;
		Persona p = new Persona();
		DataRol dr = new DataRol();
		p.setNombre(s.nextLine());
		p.setApellido(s.nextLine());
		p.setDocumento(new Documento());
		p.setTel(s.nextLine());
		p.setPassword(s.nextLine());
		p.setEmail(s.nextLine());
		p.getDocumento().setNro(s.nextLine());
		p.getDocumento().setTipo(s.nextLine());
		System.out.println("Habilitado? S/N");
		habilitado = s.nextLine();
		p.setHabilitado(habilitado == "S");
		dr.setRoles(p);

		ctrlLogin.newUser(p);

		System.out.println(p.getId());

		dr.setRoles(p);


	};

}
