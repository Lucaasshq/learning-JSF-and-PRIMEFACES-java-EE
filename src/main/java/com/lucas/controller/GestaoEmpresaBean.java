package com.lucas.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class GestaoEmpresaBean {
	
	public static Integer NUMERO = 0;
	
	public GestaoEmpresaBean() {
		NUMERO++;
	}
	
	public Integer getNumero() {
		return NUMERO;
	}

}
