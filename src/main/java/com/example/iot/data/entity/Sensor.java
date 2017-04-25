/**
 * Created by DominikH on 24.04.2017.
 */
package com.example.iot.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sensor {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String secretToken;

    @Column
    private Long created;

    @Column
    private Long updated;
}
