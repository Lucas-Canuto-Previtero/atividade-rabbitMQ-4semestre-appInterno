package school.sptech.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public record Pedido(
        @NotNull Long id,
        @NotBlank String cliente,
        @NotBlank String produto,
        @NotNull @Positive Integer quantidade
){};
