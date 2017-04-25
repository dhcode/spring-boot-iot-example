/**
 * Created by DominikH on 24.04.2017.
 */
package com.example.iot.rest;

import com.example.iot.rest.model.CreateSensor;
import com.example.iot.rest.model.SensorInfo;
import com.example.iot.rest.model.SensorStats;
import com.example.iot.service.SensorsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/sensors")
@Api(description = "Management of sensors")
public class SensorController {

    @Autowired
    private SensorsService sensorsService;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Create a new sensor")
    public SensorInfo createSensor(@RequestBody CreateSensor sensor) {
        return sensorsService.createSensor(sensor.getName());
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get list of sensors")
    public List<SensorInfo> createSensor() {
        return sensorsService.getAllSensors();
    }

    @RequestMapping(path="{sensorId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get statistics about the sensor")
    public SensorStats getSensorStats(@PathVariable("sensorId") long sensorId) {
        return sensorsService.getSensorStats(sensorId);
    }

}
