package com.carlosruanpucrs.tc2_microservico_transacao.api.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComprovanteResponse {

    String comprovante;
}

