package com.carlosruanpucrs.tc2_microservico_transacao.api.response;

import com.carlosruanpucrs.tc2_microservico_transacao.enums.SituacaoPagamentoInssEnum;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;


@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PagamentoInssResponse {

    String idInss;
    String comprovante;
    SituacaoPagamentoInssEnum resultado;
}
