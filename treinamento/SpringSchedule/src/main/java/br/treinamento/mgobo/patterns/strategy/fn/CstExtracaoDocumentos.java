package br.treinamento.mgobo.patterns.strategy.fn;

@FunctionalInterface
public interface CstExtracaoDocumentos {
	
	void extrairDocumentos(int tipoDocumento, int modeloDocumento);

}
