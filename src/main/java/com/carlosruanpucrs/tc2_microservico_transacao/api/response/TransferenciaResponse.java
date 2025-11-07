package com.carlosruanpucrs.tc2_microservico_transacao.api.response;

import com.carlosruanpucrs.tc2_microservico_transacao.enums.TipoMovimentacaoEnum;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransferenciaResponse {

    String comprovante;
    Integer contaOrigem;
    Integer contaDestino;
    BigDecimal valor;
    LocalDateTime dataHora;
    TipoMovimentacaoEnum tipoMovimentacao;
}
