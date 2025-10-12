package com.carlosruanpucrs.tc2_microservico_transacao.api.response;

import com.carlosruanpucrs.tc2_microservico_transacao.enums.TipoMovimentacaoEnum;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransacaoResponse {

    String comprovante;
    Integer contaOrigem;
    Integer contaDestino;
    BigDecimal valor;
    LocalDateTime dataHora;
    TipoMovimentacaoEnum tipoMovimentacao;
}
