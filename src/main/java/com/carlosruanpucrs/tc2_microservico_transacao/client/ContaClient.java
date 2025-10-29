package com.carlosruanpucrs.tc2_microservico_transacao.client;

import com.carlosruanpucrs.tc2_microservico_transacao.client.response.ContaResponse;
import com.carlosruanpucrs.tc2_microservico_transacao.client.response.ContaSaldoResponse;
import com.carlosruanpucrs.tc2_microservico_transacao.enums.OperacaoTransacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Component
@FeignClient(name = "conta-service", path = "/v1/contas")
public interface ContaClient {

    @GetMapping("/{numeroConta}")
    ResponseEntity<ContaResponse> contaPorNumero(@PathVariable Integer numeroConta);

    @GetMapping("/{numeroConta}/saldo")
    ResponseEntity<ContaSaldoResponse> saldoConta(@PathVariable Integer numeroConta);

    @PatchMapping("/{numeroConta}/credito")
    ResponseEntity<Void> creditar(@PathVariable Integer numeroConta,
                                  @RequestParam("valor") BigDecimal valor);

    @PatchMapping("/{numeroConta}/debito")
    ResponseEntity<Void> debitar(@PathVariable Integer numeroConta,
                                  @RequestParam("valor") BigDecimal valor);
}
