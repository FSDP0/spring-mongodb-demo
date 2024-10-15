package com.fsdp0.spring_mongodb.dto;

import com.fsdp0.spring_mongodb.domain.Sensor;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SensorSaveDto {
    private String humi;
    private String temp;

    public Sensor toDocument() {
        return Sensor.builder()
                    .sensorTemp(temp)
                    .sensorHumi(humi)
                    .build();
    }
}
