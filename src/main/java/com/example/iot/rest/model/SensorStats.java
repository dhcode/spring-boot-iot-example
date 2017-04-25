/**
 * Created by DominikH on 25.04.2017.
 */
package com.example.iot.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SensorStats {
    private Double average;
}
