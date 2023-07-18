package com.zerobase.controller;

import com.zerobase.application.dto.VoicedataDto;
import com.zerobase.application.service.VoicedataService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class VoicedataApiController {

    @Autowired
    private final VoicedataService voicedataService;


    /* READ */
    @GetMapping("/voice/{id}")
    public ResponseEntity read(@PathVariable Long id) {
        return ResponseEntity.ok(voicedataService.findById(id));
    }

    /* UPDATE(SUBMIT) */
    @PutMapping("/voice/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody VoicedataDto dto){
        voicedataService.update(id, dto);
        return ResponseEntity.ok(id);
    }

    @PostMapping("/text/{idx}/{declaration}")
    public ResponseEntity<?> postText_(
            @PathVariable Long idx,
            @PathVariable String declaration,
            @RequestBody VoicedataDto dto)
    {
        voicedataService.reroll(dto, idx, declaration);
        return new ResponseEntity(HttpStatus.OK);
    }





//    @GetMapping("/api/voice/{id}")
//    public ResponseEntity findById(@PathVariable Long id) {
//        return ResponseEntity.ok(voicedataService.findById(id));
//    }
//    @GetMapping("/api/voicedatas")
//    public ResponseEntity findAll() {
//        return ResponseEntity.ok(voicedataService.findAll());
//    }






}