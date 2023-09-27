package br.treinamento.mgobo.consumers;

import br.treinamento.mgobo.commons.SpringScheduleCommons;
import br.treinamento.mgobo.dto.RabbitMsgSchedule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@RequiredArgsConstructor
@Slf4j
public class MainConsumer implements Serializable {

    public static final long serialVersionUID = 1L;

    @RabbitListener(queues = "treinamento", concurrency = "1")
    public void consumirMensagensQueueTreinamento(String message){
        try {
            RabbitMsgSchedule rabbitMsgSchedule = SpringScheduleCommons.objectMapper.readValue(message, RabbitMsgSchedule.class);
            System.out.println(rabbitMsgSchedule.toString());
        }catch (JsonProcessingException ex){
            log.error(String.format("Erro na conversao json->object. [Erro] %s", ex.getMessage()));
        }
    }

}
