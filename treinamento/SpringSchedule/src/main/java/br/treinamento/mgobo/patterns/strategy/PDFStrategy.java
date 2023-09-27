package br.treinamento.mgobo.patterns.strategy;

import br.treinamento.mgobo.patterns.strategy.fn.CstExtracaoDocumentos;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class PDFStrategy implements CstExtracaoDocumentos {

    @RabbitListener(queues = "PDFDOCUMENTOS", concurrency = "20")
    @Override
    public void extrairDocumentos(int tipoDocumento, int modeloDocumento) {
        System.out.println("PDF Strategy...Vanvis babilonico gigante");

    }
}
