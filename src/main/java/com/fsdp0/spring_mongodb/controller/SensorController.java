package com.fsdp0.spring_mongodb.controller;

import java.util.List;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fsdp0.spring_mongodb.dto.SensorReadDto;
import com.fsdp0.spring_mongodb.dto.SensorSaveDto;
import com.fsdp0.spring_mongodb.dto.SensorUpdateDto;
import com.fsdp0.spring_mongodb.service.SensorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "[001]. Sensor REST API")
@RestController
@RequestMapping("/api/v1/sensor")
@RequiredArgsConstructor
public class SensorController {
    private final SensorService sensorService;

    @Operation(summary = "센서 관련 전체 문서 조회")
    @GetMapping
    public List<SensorReadDto> getAll() {
        return this.sensorService.findAll();
    }

    @Operation(summary = "특정 ID를 가진 문서 조회")
    @GetMapping("/{id}")
    public SensorReadDto getById(@PathVariable("id") String id) throws NotFoundException {
        return this.sensorService.findById(id);
    }

    @Operation(summary = "새로운 문서 생성")
    @PostMapping
    public SensorReadDto save(@RequestBody SensorSaveDto dto) {
        return this.sensorService.createDocument(dto);
    }

    @Operation(summary = "트정 ID를 가진 문서 정보 갱신")
    @PutMapping("/{id}")
    public SensorReadDto update(@PathVariable("id") String id, @RequestBody SensorUpdateDto dto) {
        return this.sensorService.updateDocument(id, dto);
    }

    @Operation(summary = "특정 ID를 가진 문서 삭제")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.sensorService.deleteDocument(id);
    }
}
