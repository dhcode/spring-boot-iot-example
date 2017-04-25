/**
 * Created by DominikH on 24.04.2017.
 */
package com.example.iot.service;

import com.example.iot.data.entity.Measurement;
import com.example.iot.data.entity.Sensor;
import com.example.iot.data.repository.MeasurementRepository;
import com.example.iot.data.repository.SensorRepository;
import com.example.iot.rest.model.SensorInfo;
import com.example.iot.rest.model.SensorStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class SensorsService {

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private MeasurementRepository measurementRepository;

    public SensorInfo createSensor(String name) {
        Sensor sensor = Sensor.builder()
                .name(name)
                .secretToken(new BigInteger(128, new SecureRandom()).toString(36))
                .created(System.currentTimeMillis())
                .updated(System.currentTimeMillis())
                .build();
        sensorRepository.save(sensor);
        return mapSensorInfo(sensor);
    }

    public List<SensorInfo> getAllSensors() {
        return sensorRepository.findAll()
                .stream().map(SensorsService::mapSensorInfo).collect(Collectors.toList());
    }

    public void addMeasurement(long sensorId, String secretToken, double value) {
        Sensor sensor = sensorRepository.findOne(sensorId);
        if(sensor == null) {
            throw new EntityNotFoundException("Sensor is unknown");
        }
        if(!sensor.getSecretToken().equals(secretToken)) {
            throw new IllegalArgumentException("Secret token is not allowed");
        }
        Measurement measurement = Measurement.builder()
                .sensor(sensor)
                .timestamp(System.currentTimeMillis())
                .value(value)
                .build();

        measurementRepository.save(measurement);

    }

    public SensorStats getSensorStats(long sensorId) {
        Double average = measurementRepository.getAverageBySensorId(sensorId);
        return SensorStats.builder()
                .average(average)
                .build();
    }

    private static SensorInfo mapSensorInfo(Sensor sensor) {
        return SensorInfo.builder()
                .id(sensor.getId())
                .name(sensor.getName())
                .secretToken(sensor.getSecretToken())
                .build();
    }

}
