package com.cherry.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Cherry
 * @Date: 2020/12/8
 * @Desc: ELKDocumentResponse
 */
@Data
@NoArgsConstructor
public class ELKDocumentResponseDto {

    private String status;

    private ELKDocumentDto data;

    public ELKDocumentResponseDto(String status, ELKDocumentDto data) {
        this.status = status;
        this.data = data;
    }
}
