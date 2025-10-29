package com.carlosruanpucrs.tc2_microservico_transacao.service;

import com.carlosruanpucrs.tc2_microservico_transacao.client.response.ContaResponse;
import com.carlosruanpucrs.tc2_microservico_transacao.enums.SituacaoContaEnum;
import com.carlosruanpucrs.tc2_microservico_transacao.exception.ContaBloqueadaException;
import com.carlosruanpucrs.tc2_microservico_transacao.exception.SaldoInsuficienteException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Slf4j
@Service
public class ValidationService {

    public void validarSaldoConta(BigDecimal valor, BigDecimal saldo, Integer conta) {
        if (saldo.compareTo(valor) < 0) {
            throw new SaldoInsuficienteException(conta);
        }
    }

    public void validarSituacaoContaBloqueada(ContaResponse conta) {
        if (Objects.equals(conta.getSituacao(), SituacaoContaEnum.BLOQUEADA)) {
            throw new ContaBloqueadaException(conta.getNumeroConta());
        }
    }
}
