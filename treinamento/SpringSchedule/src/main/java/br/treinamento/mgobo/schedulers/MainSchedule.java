package br.treinamento.mgobo.schedulers;

import br.treinamento.mgobo.commons.SpringScheduleCommons;
import br.treinamento.mgobo.dto.RabbitMsgSchedule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Component
@RequiredArgsConstructor
@Slf4j
public class MainSchedule implements Serializable {
    private static final long serialVersionUID = 1L;

    private final RabbitTemplate rabbitTemplate;

    @Scheduled(initialDelay = 3000, fixedDelay = 5000)
    public void executeEachFiveSeconds() {
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Executado:" + (dateTime));

        try {
            String message = SpringScheduleCommons.objectMapper.writeValueAsString(RabbitMsgSchedule.builder().data(new Date(System.currentTimeMillis())).mensagem("Enviando mensagem ao RabbitMQ...").build());
            this.rabbitTemplate.convertAndSend("treinamento-ex", "treinamento-rk", message);
        } catch (JsonProcessingException ex) {
            log.error(String.format("Erro na conversao object->json. [Erro] %s", ex.getMessage()));
        }
    }
}
