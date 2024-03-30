package com.onTrack.onTrack.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@AllArgsConstructor
public class SaveDataRequest {

    @NonNull
    @Positive
    private Long kickboardId;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    @NotNull
    @Max(100) @Min(0)
    private Integer battery;
}
