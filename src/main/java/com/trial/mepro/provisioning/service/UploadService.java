package com.trial.mepro.provisioning.service;


import com.trial.mepro.provisioning.domain.Ordering;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Service
public class UploadService {
    private final Logger log = LoggerFactory.getLogger(OrderingService.class);

    public ResponseEntity<String> upload(FilePart filePart){
        log.debug("Request to get ordering by id ");

        filePart.content()
                .map(DataBuffer::asInputStream)
                .map(inputStream -> {
                    try {
                        return inputStream.readAllBytes();
                    }catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .map(bytes -> new String(bytes))
        ;
        return ResponseEntity.ok("Berhasil");
    }
}
