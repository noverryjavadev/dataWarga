package com.datawarga.service;

import com.datawarga.dto.RequestData;
import com.datawarga.dto.ResponseData;
import com.datawarga.entity.Warga;
import com.datawarga.repo.WargaRepos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class WargaService {

    private final WargaRepos wargaRepos;

    private static final String SUCCESS = "success";

    public List<Warga> init(){
        Warga wargaBambang = new Warga();
        wargaBambang.setNama("Bambang");
        wargaBambang.setPekerjaan("Sopir");

        Warga wargaSantoso = new Warga();
        wargaSantoso.setNama("Santoso");
        wargaSantoso.setPekerjaan("Bakul bakwan");


        List<Warga>  wargas = new ArrayList<>();
        wargas.add(wargaBambang);
        wargas.add(wargaSantoso);
        return wargas;
    }


    public List<Warga> getWargaList(){
        return wargaRepos.findAll();
    }

    public ResponseData<Object> saveData(RequestData requestData){

        boolean isInsert = wargaRepos.existsByNama(requestData.getNama());
        if(isInsert){
           return ResponseData.builder()
                   .success(false)
                   .messages("Data Sudah ada di database")
                   .build();
        }

        Warga warga = new Warga();
        warga.setNama(requestData.getNama());
        warga.setPekerjaan(requestData.getPekerjaan());
        wargaRepos.save(warga);

        return ResponseData.builder()
                .success(true)
                .messages(SUCCESS)
                .build();

    }

    public ResponseData<Object> updateData(RequestData requestData){

        Warga warga = wargaRepos.findByNamaContains(requestData.getNama()).get(0);
        warga.setPekerjaan(requestData.getPekerjaan());
        wargaRepos.save(warga);

        return ResponseData.builder()
                .success(true)
                .messages(SUCCESS)
                .build();

    }


    public ResponseData<Object> showData(Long id){
        Warga warga = wargaRepos.findById(id).orElse(null);
        return ResponseData.builder()
                .success(true)
                .messages(SUCCESS)
                .data(warga)
                .build();
    }






}
