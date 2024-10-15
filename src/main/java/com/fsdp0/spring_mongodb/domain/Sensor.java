package com.fsdp0.spring_mongodb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fsdp0.spring_mongodb.dto.SensorReadDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Document(collection = "sensor")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Sensor {
    @Id
    private String sensorId;

    private String sensorTemp;

    private String sensorHumi;

    public SensorReadDto toDto() {
        return SensorReadDto.builder()
                            .id(sensorId)
                            .temp(sensorTemp)
                            .humi(sensorHumi)
                            .build();
    }
}
