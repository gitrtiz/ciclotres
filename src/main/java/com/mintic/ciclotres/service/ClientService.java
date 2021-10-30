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
    
    public Client update(Client client){
        if (client.getIdClient()!=null){
            Optional<Client> cli = clientRepository.getClient(client.getIdClient());
            if (!cli.isEmpty()) {
                if (client.getEmail()!=null) {
                    cli.get().setEmail(client.getEmail());
                }
                if (client.getName()!=null) {
                    cli.get().setName(client.getName());
                }
                if (client.getPassword()!=null) {
                    cli.get().setPassword(client.getPassword());
                }
                if (client.getAge()!=null) {
                    cli.get().setAge(client.getAge());
                }
                return clientRepository.save(cli.get());
            }
        }
        return client;
    }
    
    public boolean delete(int id) {
        Optional<Client> cli = getClient(id);
        if (!cli.isEmpty()) {
            clientRepository.delete(cli.get());
            return true;
        }
        return false;
    }
}
