package com.example.iot.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by DominikH on 24.04.2017.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeasurementPK implements Serializable {
    private Long sensor;
    private Long timestamp;
}
