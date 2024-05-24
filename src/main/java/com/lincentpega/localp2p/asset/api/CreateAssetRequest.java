package com.lincentpega.localp2p.asset.api;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateAssetRequest {
    @NotNull
    @Size(min = 3, max = 4)
    private String name;

    private boolean isFiat;
}
