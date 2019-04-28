package com.learningcucumber.firststeps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class Learning_cucumber {

	@Dado("^Criei o arquivo corretamente$")
	public void crieiOArquivoCorretamente() throws Throwable {
	    System.out.println("Passed");
	}

	@Quando("^Executar$")
	public void executar() throws Throwable {
	    System.out.println("Passed");
	}

	@Entao("^A especificacao deve executar com sucesso$")
	public void aEspecificacaoDeveExecutarComSucesso() throws Throwable {
		System.out.println("Passed");
	}

}
