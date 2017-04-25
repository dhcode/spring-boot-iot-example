/**
 * Created by DominikH on 24.04.2017.
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
public class SensorInfo {
    private long id;
    private String name;
    private String secretToken;
}
