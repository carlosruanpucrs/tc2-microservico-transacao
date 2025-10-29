package com.carlosruanpucrs.tc2_microservico_transacao.api.request;

import com.carlosruanpucrs.tc2_microservico_transacao.enums.SituacaoPagamentoInssEnum;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PagamentoInssRequest {

    String idInss;
    Integer numeroConta;
    Integer numeroBeneficio;
    LocalDate dataPagamento;
    BigDecimal valorPagamento;
    SituacaoPagamentoInssEnum situacao;
}
