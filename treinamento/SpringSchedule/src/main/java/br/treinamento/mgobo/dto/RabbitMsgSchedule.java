package br.treinamento.mgobo.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RabbitMsgSchedule implements Serializable {
    public static final long serialVersionUID = 1l;
    private Date data;
    private String mensagem;
}
