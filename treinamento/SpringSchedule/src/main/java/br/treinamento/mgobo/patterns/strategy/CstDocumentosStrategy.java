package br.treinamento.mgobo.patterns.strategy;

import br.treinamento.mgobo.patterns.strategy.fn.CstExtracaoDocumentos;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class CstDocumentosStrategy {

    private RabbitTemplate rabbitTemplate;
    private CstExtracaoDocumentos cstExtracaoDocumentos;

    public CstDocumentosStrategy(CstExtracaoDocumentos cstExtracaoDocumentos, RabbitTemplate rabbitTemplate) {
        this.cstExtracaoDocumentos = cstExtracaoDocumentos;
        this.rabbitTemplate = rabbitTemplate;
    }

    public void mudarTipoExtracao(CstExtracaoDocumentos cstExtracaoDocumentos, RabbitTemplate rabbitTemplate) {
        this.cstExtracaoDocumentos = cstExtracaoDocumentos;
        this.rabbitTemplate = rabbitTemplate;
    }

    public void extrairDocumentos(int tipoDocumento, int modeloDocumento) {
        this.cstExtracaoDocumentos.extrairDocumentos(tipoDocumento, modeloDocumento);
        if(this.rabbitTemplate != null) {
            this.rabbitTemplate.convertAndSend("", "", "");
        }
    }
}
