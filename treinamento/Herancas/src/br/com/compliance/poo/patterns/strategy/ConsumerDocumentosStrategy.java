package br.com.compliance.poo.patterns.strategy;

public class ConsumerDocumentosStrategy {

	public static void main(String[] args) {
		var tipoDocumento = 1;
		switch(tipoDocumento) {
			case 1 -> {
				CstDocumentosStrategy cstDocumentosStrategy = new CstDocumentosStrategy(new XMLStrategy());
				cstDocumentosStrategy.extrairDocumentos(1, 1);
			}
			case 2 -> {
				CstDocumentosStrategy cstDocumentosStrategy = new CstDocumentosStrategy(new PDFStrategy());
				cstDocumentosStrategy.extrairDocumentos(1, 1);
			}
			default -> throw new IllegalArgumentException("Unexpected value: " + tipoDocumento);
		}
	}
	
}
