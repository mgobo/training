package br.treinamento.mgobo.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class SpringScheduleConfig {

    private final AmqpAdmin amqpAdmin;

    @EventListener(classes = ApplicationStartedEvent.class)
    public void afterStarted() {
        Queue q = new Queue("treinamento", true);

        ExchangeBuilder exchangeBuilder = ExchangeBuilder.directExchange("treinamento-ex");
        Exchange exchange = exchangeBuilder.build();
        BindingBuilder.GenericArgumentsConfigurer builder = BindingBuilder.bind(q).to(exchange).with("treinamento-rk");
        Binding binding = builder.noargs();

        this.amqpAdmin.declareQueue(q);
        this.amqpAdmin.declareExchange(exchange);
        this.amqpAdmin.declareBinding(binding);

        System.out.println("App has been started..."+(LocalDateTime.now()));
    }
}
