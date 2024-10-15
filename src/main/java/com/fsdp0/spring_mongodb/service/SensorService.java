package com.fsdp0.spring_mongodb.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;
import com.fsdp0.spring_mongodb.dto.SensorReadDto;
import com.fsdp0.spring_mongodb.dto.SensorSaveDto;
import com.fsdp0.spring_mongodb.dto.SensorUpdateDto;
import com.fsdp0.spring_mongodb.repository.SensorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class SensorService {
    private final SensorRepository sensorRepository;

    public List<SensorReadDto> findAll() {
        return this.sensorRepository.findAll()
                                    .stream()
                                    .map((document) -> document.toDto())
                                    .toList();
    }

    public SensorReadDto findById(String id) {
        return this.sensorRepository.findById(id)
                                    .orElseThrow(() -> {
                                        log.error("해당 문서 ID가 존재하지 않습니다 : {}", id);

                                        return new NoSuchElementException("해당 문서 ID가 존재하지 않습니다.");
                                    })
                                    .toDto();
    }

    public SensorReadDto createDocument(SensorSaveDto dto) {
        return this.sensorRepository.save(dto.toDocument()).toDto();
    }

    public SensorReadDto updateDocument(String id, SensorUpdateDto dto) {
        return this.sensorRepository.save(dto.toDocument(id)).toDto();
    }

    public void deleteDocument(String id) {
        this.sensorRepository.deleteById(id);
    }
}
