package com.learningcucumber.firststeps;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class Learning_cucumber {

	@Dado("^Criei o arquivo corretamente$")
	public void criei_o_arquivo_corretamente() throws Throwable {
	    System.out.println("Step passed example!");
	}

	@Quando("^Executar$")
	public void executar() throws Throwable {
		 throw new PendingException("Step failed example!");
	}

	@Entao("^A especificacao deve executar com sucesso$")
	public void a_especificacao_deve_executar_com_sucesso() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException("Step skipped example!");
	}

}
