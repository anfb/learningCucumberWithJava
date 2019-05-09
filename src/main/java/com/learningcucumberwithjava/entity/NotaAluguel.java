package com.learningcucumberwithjava.entity;

import java.util.Date;

public class NotaAluguel {

	private Integer preco;
	private Date dataEntrega;

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	

	public void setPreco(Integer preco) {
		this.preco = preco;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}
	
	
}
