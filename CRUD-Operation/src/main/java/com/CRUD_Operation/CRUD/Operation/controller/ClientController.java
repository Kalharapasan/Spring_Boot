package com.CRUD_Operation.CRUD.Operation.controller;

import com.CRUD_Operation.CRUD.Operation.model.Client;
import com.CRUD_Operation.CRUD.Operation.service.ClientServise;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final ClientServise clientServise;

    @GetMapping
    public ResponseEntity <List<Client>> getAll(){
        return clientServise.getAllClient();
    }
    @PostMapping
    public ResponseEntity <Client> saveClient(@RequestBody Client client){
        return clientServise.saveClient(client);
    }
    @GetMapping ("/{clinetId}")
    public ResponseEntity <Client> getClientById(@PathVariable Long clinetId){
        return clientServise.getClientById(clinetId);
    }
    @PutMapping("/{clientId}")
    public ResponseEntity <Client> updateClient(@PathVariable Long clientId,@RequestBody Client client){
        return clientServise.updateClient(clientId,client);
    }
    @DeleteMapping("/{clientId}")
    public ResponseEntity <Client> deleteClient(@PathVariable Long clientId){
        return clientServise.deleteClient(clientId);
    }
}
