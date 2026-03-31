package com.datawarga.controller;

import com.datawarga.dto.ResponseData;
import com.datawarga.entity.Warga;
import com.datawarga.service.WargaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
public class WargaController {

    @Autowired
    private WargaService wargaService;

    @GetMapping(value = "/warga")
    public ResponseEntity<?> findAll(@RequestHeader("Authorization") String auth){

        try {
            List<Warga> wargas = wargaService.init();
            return ResponseEntity.ok().body(ResponseData.builder()
                    .success(true)
                    .messages("successfully")
                    .data(wargas.size())
                    .build());

        }catch (Exception e){
            return ResponseEntity.badRequest().body(ResponseData.builder()
                    .success(false)
                    .messages("Authorization Invalid")
                    .data(null)
                    .build());

        }

    }



//    @PostMapping(value = "save/warga")
//    public ResponseEntity<?> save(@RequestBody RequestData requestData, @RequestHeader("Authorization") String auth){
//        ResponseData responseData = wargaService.saveData(requestData);
//        return ResponseEntity.ok().body(responseData);
//    }



//    @PostMapping(value = "save/warga")
//    public ResponseEntity<ResponseData<Warga>> create(@Valid @RequestBody Warga warga, Errors errors){
//
//        ResponseData<Warga> responseData = new ResponseData<>();
//
//        if (errors.hasErrors()){
//            for (ObjectError error : errors.getAllErrors()){
//                responseData.getMessages().add(error.getDefaultMessage());
//            }
//            responseData.setSuccess(false);
//            responseData.setData(null);
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
//        }
//        responseData.setSuccess(true);
//        responseData.setData(wargaService.save(warga));
//        return ResponseEntity.ok(responseData);
//    }

//    @GetMapping(value = "warga/{id}")
//    public Warga findOne(@PathVariable("id") Long id){
//        return wargaService.findOne(id);
//    }

//    @PutMapping(value = "update/warga")
//    public Warga update(@RequestBody Warga warga){
//        return wargaService.update(warga);
//    }

//    @PutMapping(value = "save/warga")
//    public ResponseEntity<ResponseData<Warga>> update(@Valid @RequestBody Warga warga, Errors errors){
//        ResponseData<Warga> responseData = new ResponseData<>();
//
//        if (errors.hasErrors()){
//            for (ObjectError error : errors.getAllErrors()){
//                responseData.getMessages().add(error.getDefaultMessage());
//            }
//            responseData.setSuccess(false);
//            responseData.setData(null);
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
//        }
//        responseData.setSuccess(true);
//        responseData.setData(wargaService.save(warga));
//        return ResponseEntity.ok(responseData);
//    }

//    @GetMapping(value = "getalldata")
//    public ResponseEntity<?> findAll(@RequestHeader("Authorization") String auth){
//
//        try {
//            List<Warga> wargas = wargaService.findAll();
//            return ResponseEntity.ok().body(ResponseData.builder()
//                    .success(true)
//                    .messages("successfully")
//                    .data(wargas.size())
//                    .build());
//
//        }catch (Exception e){
//            return ResponseEntity.badRequest().body(ResponseData.builder()
//                    .success(false)
//                    .messages("Authorization Invalid")
//                    .data(null)
//                    .build());
//
//        }
//
//    }

//    @GetMapping(value = "warga/{nama}")
//    public List<Warga> findByNama(@PathVariable("nama") String nama){
//        return wargaService.findByNama(nama);
//    }

//    @DeleteMapping(value = "warga/{id}")
//    public void softDelete(@PathVariable Long id){
//        wargaService.softDelete(id);
//    }

//    @GetMapping("/getalldata")
//    public List<Warga> findAll(){
//        return wargaService.findAll();
//    }



}
