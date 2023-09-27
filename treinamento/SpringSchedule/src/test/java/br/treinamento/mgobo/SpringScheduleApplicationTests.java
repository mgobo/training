package br.treinamento.mgobo;

import br.treinamento.mgobo.commons.SpringScheduleCommons;
import br.treinamento.mgobo.dto.RabbitMsgSchedule;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

class SpringScheduleApplicationTests {

    @Test
    void createJsonRabbitScheduleMsg() {
        try {
            RabbitMsgSchedule rabbitMsgSchedule = RabbitMsgSchedule.builder().data(new Date(System.currentTimeMillis())).mensagem("Enviando mensagem ao RabbitMQ...").build();
            String json = SpringScheduleCommons.objectMapper.writeValueAsString(rabbitMsgSchedule);
            System.out.println(json);
            Assertions.assertEquals(json != null, !json.equals(null));
        }catch (JsonProcessingException ex){
            Assertions.fail(String.format("Falha na conversao object -> json. [Erro] = %s", ex.getMessage()));
        }
    }
}
