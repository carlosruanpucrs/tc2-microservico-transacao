package com.carlosruanpucrs.tc2_microservico_transacao.api;

import com.carlosruanpucrs.tc2_microservico_transacao.api.request.TransferenciaRequest;
import com.carlosruanpucrs.tc2_microservico_transacao.api.response.ComprovanteResponse;
import com.carlosruanpucrs.tc2_microservico_transacao.service.TransacaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/transferencias")
public class TransacaoApi {

    private final TransacaoService transacaoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<ComprovanteResponse> transferir(@RequestBody TransferenciaRequest request) {
        return ResponseEntity.ok(transacaoService.transferir(request));
    }
}

