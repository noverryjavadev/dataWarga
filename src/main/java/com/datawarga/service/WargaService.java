package com.datawarga.service;

import com.datawarga.dto.RequestData;
import com.datawarga.dto.ResponseData;
import com.datawarga.entity.Warga;
import com.datawarga.repo.WargaRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WargaService {

    @Autowired
    private WargaRepos wargaRepos;


    private Warga wargaBambang;
    private Warga wargaSantoso;


    public List<Warga> init(){
        wargaBambang = new Warga();
        wargaBambang.setNama("Bambang");
        wargaBambang.setPekerjaan("Sopir");

        wargaSantoso = new Warga();
        wargaSantoso.setNama("Santoso");
        wargaSantoso.setPekerjaan("Bakul bakwan");


        return null;
    }


    public List<Warga> getWargaList(){
        return wargaRepos.findAll();
    }



//    public Warga save(Warga warga){
//        return wargaRepos.save(warga);
//    }

    public ResponseData saveData(RequestData requestData){

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
                .messages("success")
                .build();

    }

    public ResponseData updateData(RequestData requestData){

        Warga warga = wargaRepos.findByNamaContains(requestData.getNama()).get(0);
        warga.setPekerjaan(requestData.getPekerjaan());
        wargaRepos.save(warga);

        return ResponseData.builder()
                .success(true)
                .messages("success")
                .build();

    }






}
