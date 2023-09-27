package br.treinamento.mgobo.patterns.strategy.consumer;

import br.treinamento.mgobo.patterns.strategy.CstDocumentosStrategy;
import br.treinamento.mgobo.patterns.strategy.PDFStrategy;
import br.treinamento.mgobo.patterns.strategy.XMLStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsumerDocumentosStrategy {

	private final RabbitTemplate rabbitTemplate;

	@RabbitListener(queues = "DOCUMENTOS-MINING", concurrency = "20")
	public void consumerDocumentos(){
		var tipoDocumento = 1;
		switch(tipoDocumento) {
			case 1 -> {
				CstDocumentosStrategy cstDocumentosStrategy = new CstDocumentosStrategy(new XMLStrategy(), this.rabbitTemplate);
				cstDocumentosStrategy.extrairDocumentos(1, 1);
			}
			case 2 -> {
				CstDocumentosStrategy cstDocumentosStrategy = new CstDocumentosStrategy(new PDFStrategy(), this.rabbitTemplate);
				cstDocumentosStrategy.extrairDocumentos(1, 1);
			}
			default -> throw new IllegalArgumentException("Unexpected value: " + tipoDocumento);
		}
	}


	public static void main(String[] args) {
		var tipoDocumento = 1;
		switch(tipoDocumento) {
			case 1 -> {
				CstDocumentosStrategy cstDocumentosStrategy = new CstDocumentosStrategy(new XMLStrategy(), null);
				cstDocumentosStrategy.extrairDocumentos(1, 1);
			}
			case 2 -> {
				CstDocumentosStrategy cstDocumentosStrategy = new CstDocumentosStrategy(new PDFStrategy(), null);
				cstDocumentosStrategy.extrairDocumentos(1, 1);
			}
			default -> throw new IllegalArgumentException("Unexpected value: " + tipoDocumento);
		}
	}
	
}
