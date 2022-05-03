package com.cherry.dtos;

import com.cherry.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Cherry
 * @Date: 2020/12/8
 * @Desc: ELKDocumentVo
 */
@Data
@NoArgsConstructor
public class ELKDocumentDto {

    private String index;

    private User user;

    public ELKDocumentDto(String index, User user) {
        this.index = index;
        this.user = user;
    }
}
