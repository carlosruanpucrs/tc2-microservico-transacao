package com.carlosruanpucrs.tc2_microservico_transacao.service;

import com.carlosruanpucrs.tc2_microservico_transacao.api.request.TransferenciaRequest;
import com.carlosruanpucrs.tc2_microservico_transacao.api.response.ComprovanteResponse;
import com.carlosruanpucrs.tc2_microservico_transacao.api.response.TransferenciaResponse;
import com.carlosruanpucrs.tc2_microservico_transacao.client.ContaClient;
import com.carlosruanpucrs.tc2_microservico_transacao.enums.OperacaoTransacaoEnum;
import com.carlosruanpucrs.tc2_microservico_transacao.mapper.TransacaoMapper;
import com.carlosruanpucrs.tc2_microservico_transacao.repository.TransacaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.carlosruanpucrs.tc2_microservico_transacao.enums.TipoMovimentacaoEnum.TRANSFERENCIA_INTERNA;

@Slf4j
@RequiredArgsConstructor
@Service
public class TransacaoService {

    private final ValidationService validationService;
    private final ContaClient contaClient;
    private final TransacaoRepository transacaoRepository;

    public ComprovanteResponse transferir(TransferenciaRequest request) {
        var contaOrigem = contaClient.contaPorNumero(request.getContaOrigem()).getBody();
        var contaDestino = contaClient.contaPorNumero(request.getContaDestino()).getBody();

        validationService.validarSaldoConta(request.getValor(), contaOrigem);
        validationService.validarSituacaoContaBloqueada(contaOrigem);

        contaClient.atualizarSaldo(contaOrigem.getNumeroConta(), request.getValor(), OperacaoTransacaoEnum.DEBITO);
        contaClient.atualizarSaldo(contaDestino.getNumeroConta(), request.getValor(), OperacaoTransacaoEnum.CREDITO);

        var transacao = TransacaoMapper.mapToTransacaoEntity(request.getContaOrigem(), request.getContaDestino(), request.getValor(), TRANSFERENCIA_INTERNA);
        transacaoRepository.save(transacao);

        return TransacaoMapper.mapToTransferenciaResponse(transacao.getComprovante());
    }

    public List<TransferenciaResponse> listarTransferenciasPorConta(Integer numeroConta) {
        return transacaoRepository.findByContaOrigemOrContaDestino(numeroConta, numeroConta)
                .stream()
                .map(TransacaoMapper::mapToTransacaoResponse)
                .toList();
    }
}
