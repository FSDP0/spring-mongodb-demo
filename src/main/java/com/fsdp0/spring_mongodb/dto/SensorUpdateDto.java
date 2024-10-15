package com.fsdp0.spring_mongodb.dto;

import com.fsdp0.spring_mongodb.domain.Sensor;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SensorUpdateDto {
    private String temp;
    private String humi;

    public Sensor toDocument(String id) {
        return Sensor.builder()
                    .sensorId(id)
                    .sensorTemp(temp)
                    .sensorHumi(humi)
                    .build();
    }
}
