/**
 * Created by DominikH on 24.04.2017.
 */
package com.example.iot.rest.model;

import lombok.Data;


@Data
public class MeasurementInput {
    private long sensorId;
    private String secretToken;
    private double value;
}
