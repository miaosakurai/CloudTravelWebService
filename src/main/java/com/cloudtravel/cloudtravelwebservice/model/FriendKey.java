package com.cloudtravel.cloudtravelwebservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FriendKey {
    private Integer fromUserId;

    private Integer toUserId;

}