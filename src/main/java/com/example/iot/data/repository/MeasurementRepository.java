/**
 * Created by DominikH on 24.04.2017.
 */
package com.example.iot.data.repository;

import com.example.iot.data.entity.Measurement;
import com.example.iot.data.entity.MeasurementPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface MeasurementRepository extends JpaRepository<Measurement, MeasurementPK> {

    @Query("select avg(m.value) from Measurement m where m.sensor.id = :sensorId")
    Double getAverageBySensorId(@Param("sensorId") Long sensorId);
}
