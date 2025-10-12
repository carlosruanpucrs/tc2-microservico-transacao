package com.carlosruanpucrs.tc2_microservico_transacao.mapper;

import com.carlosruanpucrs.tc2_microservico_transacao.api.response.ComprovanteResponse;
import com.carlosruanpucrs.tc2_microservico_transacao.api.response.TransacaoResponse;
import com.carlosruanpucrs.tc2_microservico_transacao.enums.TipoMovimentacaoEnum;
import com.carlosruanpucrs.tc2_microservico_transacao.model.entity.TransacaoEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransacaoMapper {

    public static TransacaoEntity mapToTransacaoEntity(Integer contaOrigem, Integer contaDestino, BigDecimal valor,
                                                       TipoMovimentacaoEnum tipoMovimentacao) {
        return TransacaoEntity.builder()
                .comprovante(tipoMovimentacao.getDescricao().concat(UUID.randomUUID().toString()))
                .valor(valor)
                .contaOrigem(contaOrigem)
                .contaDestino(contaDestino)
                .tipoMovimentacao(tipoMovimentacao)
                .dataHora(LocalDateTime.now())
                .build();
    }

    public static ComprovanteResponse mapToTransferenciaResponse(String comprovante) {
        return ComprovanteResponse.builder()
                .comprovante(comprovante)
                .build();
    }

    public static TransacaoResponse mapToTransacaoResponse(TransacaoEntity transacaoEntity) {
        return TransacaoResponse.builder()

                .build();
    }
}
