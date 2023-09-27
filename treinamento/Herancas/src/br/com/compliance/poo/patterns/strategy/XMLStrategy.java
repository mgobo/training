package br.com.compliance.poo.patterns.strategy;

import br.com.compliance.poo.patterns.strategy.fn.CstExtracaoDocumentos;

public class XMLStrategy implements CstExtracaoDocumentos{

	@Override
	public void extrairDocumentos(int tipoDocumento, int modeloDocumento) {
		System.out.println("XML Strategy...Vanvis babilonico");
		
	}
	
}