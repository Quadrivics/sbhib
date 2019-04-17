package com.sergebosman.sbhib.controller;

import com.sergebosman.sbhib.entity.Animal;
import com.sergebosman.sbhib.entity.Transfer;
import com.sergebosman.sbhib.entity.CareRequest;
import com.sergebosman.sbhib.service.IAnimalService;
import com.sergebosman.sbhib.service.ITransferService;
import com.sergebosman.sbhib.service.ICareRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/animaldata")
public class AnimalController {

    @Autowired
    private IAnimalService animalService;

    @Autowired
    private ICareRequestService careRequestService;

    @Autowired
    private ITransferService transferService;

    @PostMapping("/animal")
    public ResponseEntity<Void> addAnimal(@RequestBody Animal animal, UriComponentsBuilder builder) {

        boolean flag = animalService.addAnimal(animal);
        if(!flag) return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("animal/{id}").buildAndExpand(animal.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/animal/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable("id") Integer id) {
        Animal nml = animalService.getAnimalById(id);
        return new ResponseEntity<Animal>(nml, HttpStatus.OK);
    }

    @GetMapping("/animals")
    public ResponseEntity<List<Animal>> getAllAnimals() {
        List<Animal> list = animalService.getAllAnimals();
        return new ResponseEntity<List<Animal>>(list, HttpStatus.OK);
    }

    @PutMapping("/animal")
    public ResponseEntity<Animal> updateAnimal(@RequestBody Animal animal) {
        animalService.updateAnimal(animal);
        return new ResponseEntity<Animal>(animal, HttpStatus.OK);
    }

    @DeleteMapping("/animal/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable("id") Integer id) {
        animalService.deleteAnimal(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/carerequest/{id}")
    public ResponseEntity<CareRequest> getCareRequestById(@PathVariable("id") Integer id) {
        CareRequest careRequest = careRequestService.getCareRequestById(id);
        return new ResponseEntity<CareRequest>(careRequest, HttpStatus.OK);

    }

    @GetMapping("/carerequests")
    public ResponseEntity<List<CareRequest>> getAllCareRequests() {
        List<CareRequest> list = careRequestService.getAllCareRequests();
        return new ResponseEntity<List<CareRequest>>(list, HttpStatus.OK);
    }

    @PostMapping("/carerequest")
    public ResponseEntity<Void> addCareRequest(@RequestBody CareRequest careRequest, UriComponentsBuilder builder) {
        careRequestService.addCareRequest(careRequest);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/careRequest/{id}").buildAndExpand(careRequest.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/carerequest")
    public ResponseEntity<CareRequest> updateCareRequest(@RequestBody CareRequest careRequest) {
        careRequestService.updateCareRequest(careRequest);
        return new ResponseEntity<CareRequest>(careRequest, HttpStatus.OK);
    }

    @DeleteMapping("/carerequest/{id}")
    public ResponseEntity<Void> deleteCareRequest(@PathVariable("id") Integer id) {
        careRequestService.deleteCareRequest(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/careRequest/{id}")
    public ResponseEntity<CareRequest> closeCareRequest(@PathVariable("id") Integer id) {
        careRequestService.closeCareRequest(id);
        return new ResponseEntity<CareRequest>(HttpStatus.OK);
    }

    @PostMapping("/transfer")
    public ResponseEntity<Void> addTransfer(@RequestBody Transfer transfer, UriComponentsBuilder builder) {
        transferService.addTransfer(transfer);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/transfer").buildAndExpand(transfer.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/transfer/{nmlid}/{transferid}")
    public ResponseEntity<Void> addApptoTransfer(@PathVariable("nmlid") Integer nmlid, @PathVariable("transferid") Integer transferid, UriComponentsBuilder builder) {
        transferService.addAnimal(nmlid, transferid);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
