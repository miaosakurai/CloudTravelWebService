package com.cloudtravel.cloudtravelwebservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Friend extends FriendKey {
    private Integer status;

}