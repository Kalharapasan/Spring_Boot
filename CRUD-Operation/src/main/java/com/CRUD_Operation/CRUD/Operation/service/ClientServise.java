package com.CRUD_Operation.CRUD.Operation.service;

import com.CRUD_Operation.CRUD.Operation.doa.ClientRepository;
import com.CRUD_Operation.CRUD.Operation.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServise {

    final ClientRepository  clientRepository;

    public ResponseEntity<List<Client>> getAllClient() {
        List<Client> clients = clientRepository.findAll();
        return ResponseEntity.ok(clients);
    }

    public ResponseEntity<Client> saveClient(Client client) {
        client =  clientRepository.save(client);
        if(client.getClientId() == null){
            throw new RuntimeException("Client Id is Null");
        }else{
            return ResponseEntity.ok(client);
        }
    }

    public ResponseEntity<Client> getClientById(Long clinetId) {
        if(clinetId == null){
            throw new RuntimeException("ClinetId is Null");
        }else{
            Optional<Client> client = clientRepository.findById(clinetId);
            if(client.isPresent()){
                return ResponseEntity.ok(client.get());
            }else{
                throw new RuntimeException("Client Not Found");
            }
        }
    }

    public ResponseEntity<Client> updateClient(Long clientId, Client client) {
        if (clientId == null) {
            throw new RuntimeException("Client Id is Null");
        }else{
            Optional <Client> clientOptional = clientRepository.findById(clientId);
            if(clientOptional.isPresent()){
                Client updatedClient = clientOptional.get();
                updatedClient.setFirstName(client.getFirstName());
                updatedClient.setLastName(client.getLastName());
                updatedClient.setEmail(client.getEmail());
                updatedClient.setAge(client.getAge());
                updatedClient.setAddress(client.getAddress());

                updatedClient = clientRepository.save(updatedClient);
                return ResponseEntity.ok(updatedClient);
            }else{
                throw new RuntimeException("Client Not Found");
            }
        }
    }

    public ResponseEntity<Client> deleteClient(Long clientId) {
        if(clientId == null){
            throw new RuntimeException("Client Id is Null");
        }else{
            Optional<Client> client = clientRepository.findById(clientId);
            if(client.isPresent()){
                clientRepository.delete(client.get());
                return ResponseEntity.ok(client.get());
            }else{
                throw new RuntimeException("Client Not Found");
            }
        }
    }
}
