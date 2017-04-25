/**
 * Created by DominikH on 24.04.2017.
 */
package com.example.iot.rest;

import com.example.iot.rest.model.MeasurementInput;
import com.example.iot.service.SensorsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "api/measurement")
@Api(value = "Submit new measurements")
public class DataInputController {

    @Autowired
    SensorsService sensorsService;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Add a new value to a sensors data")
    public void addMeasurement(@RequestBody MeasurementInput measurementInput) {
        sensorsService.addMeasurement(
                measurementInput.getSensorId(),
                measurementInput.getSecretToken(),
                measurementInput.getValue());
    }

}
