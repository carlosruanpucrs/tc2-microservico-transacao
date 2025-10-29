package com.carlosruanpucrs.tc2_microservico_transacao.api;

import com.carlosruanpucrs.tc2_microservico_transacao.api.request.PagamentoInssRequest;
import com.carlosruanpucrs.tc2_microservico_transacao.api.response.PagamentoInssResponse;
import com.carlosruanpucrs.tc2_microservico_transacao.service.TransacaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/v1/pagamentos/inss", produces = MediaType.APPLICATION_JSON_VALUE)
public class PagamentoInssApi {

    private final TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<PagamentoInssResponse> pagarInss(@RequestBody PagamentoInssRequest request) {
        return ResponseEntity.ok(transacaoService.pagarInss(request));
    }
}
