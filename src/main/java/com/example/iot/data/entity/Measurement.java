/**
 * Created by DominikH on 24.04.2017.
 */
package com.example.iot.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(MeasurementPK.class)
public class Measurement {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private Sensor sensor;

    @Id
    private Long timestamp;

    @Column
    private double value;
}
