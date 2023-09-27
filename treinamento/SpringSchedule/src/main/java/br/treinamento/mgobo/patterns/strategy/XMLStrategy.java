package br.treinamento.mgobo.patterns.strategy;


import br.treinamento.mgobo.patterns.strategy.fn.CstExtracaoDocumentos;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class XMLStrategy implements CstExtracaoDocumentos {

	@RabbitListener(queues = "XMLDOCUMENTOS", concurrency = "20")
    @Override
    public void extrairDocumentos(int tipoDocumento, int modeloDocumento) {
        System.out.println("XML Strategy...Vanvis babilonico");

    }
}