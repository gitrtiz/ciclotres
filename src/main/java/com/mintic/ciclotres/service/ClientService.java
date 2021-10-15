package com.mintic.ciclotres.service;

import com.mintic.ciclotres.dao.ClientRepository;
import com.mintic.ciclotres.entities.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Edgar
 */
@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;
    
    public List<Client> getAll() {return (List<Client>) clientRepository.getAll();};
    
    public Optional<Client> getClient(int id) {return clientRepository.getClient(id);};
    
    public Client save(Client client) {
        if (client.getIdClient()==null) {
            return clientRepository.save(client);
        }
        else {
            Optional<Client> co = clientRepository.getClient(client.getIdClient());
            if (co.isEmpty()){
                return clientRepository.save(client);
            }
            else {
                return client;
            }
        }
    }
}
