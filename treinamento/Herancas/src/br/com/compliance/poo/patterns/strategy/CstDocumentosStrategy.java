package br.com.compliance.poo.patterns.strategy;

import br.com.compliance.poo.patterns.strategy.fn.CstExtracaoDocumentos;

public class CstDocumentosStrategy {

	private CstExtracaoDocumentos cstExtracaoDocumentos;
	
	public CstDocumentosStrategy(CstExtracaoDocumentos cstExtracaoDocumentos) {
		this.cstExtracaoDocumentos = cstExtracaoDocumentos;
	}
	
	public void mudarTipoExtracao(CstExtracaoDocumentos cstExtracaoDocumentos) {
		this.cstExtracaoDocumentos = cstExtracaoDocumentos;
	}
	
	public void extrairDocumentos(int tipoDocumento, int modeloDocumento) {
		this.cstExtracaoDocumentos.extrairDocumentos(tipoDocumento, modeloDocumento);
	}
}
