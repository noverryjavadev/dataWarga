package com.datawarga.controller;

import com.datawarga.dto.RequestData;
import com.datawarga.dto.ResponseData;
import com.datawarga.entity.Warga;
import com.datawarga.service.WargaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class WargaController {

    private final WargaService wargaService;

    @GetMapping(value = "/warga")
    public ResponseEntity<?> findAll(){

        try {
            List<Warga> wargas = wargaService.getWargaList();
            return ResponseEntity.ok().body(ResponseData.builder()
                    .success(true)
                    .messages("successfully")
                    .data(wargas)
                    .build());

        }catch (Exception e){
            return ResponseEntity.badRequest().body(ResponseData.builder()
                    .success(false)
                    .messages("Authorization Invalid")
                    .data(null)
                    .build());

        }

    }

    @PostMapping(value = "save/warga")
    public ResponseEntity<Object> save(@RequestBody RequestData requestData){
        ResponseData responseData = wargaService.saveData(requestData);
        return ResponseEntity.ok().body(responseData);
    }



}
