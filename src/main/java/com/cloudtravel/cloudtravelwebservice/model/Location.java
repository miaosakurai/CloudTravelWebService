package com.cloudtravel.cloudtravelwebservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Location {
    private Integer locationId;

    private String name;

    private String address;

    private Byte level;

    private String openTime;

    private Double latitude;

    private Double longitude;

    private String description;

}