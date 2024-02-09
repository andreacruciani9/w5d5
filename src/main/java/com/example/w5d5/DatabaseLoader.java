package com.example.w5d5;

import com.example.w5d5.entities.*;
import com.example.w5d5.repositories.EdificioRepository;
import com.example.w5d5.repositories.PostazioneRepository;
import com.example.w5d5.repositories.PrenotazioneRepository;
import com.example.w5d5.repositories.UtenteRepository;
import com.example.w5d5.services.PrenotazioneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DatabaseLoader implements CommandLineRunner {
    @Autowired
    private EdificioRepository edificioRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    private PrenotazioneService prenotazioneService;

    @Override
    public void run(String... args) throws Exception {
        // Creazione di alcuni dati di esempio e salvataggio nel database

        Edificio edificio = new Edificio();
        edificio.setNome("Edificio A");
        edificio.setIndirizzo("Via Example, 123");
        edificio.setCitta("Città Example");
        edificioRepository.save(edificio);

        Postazione postazione1 = new Postazione();
        postazione1.setCodice("P001");
        postazione1.setDescrizione("Postazione Privata");
        postazione1.setTipoPostazione(TipoPostazione.PRIVATO);
        postazione1.setNumeroMassimoOccupanti(1);
        postazione1.setEdificio(edificio);
        postazioneRepository.save(postazione1);

        Utente utente = new Utente();
        utente.setUsername("john_doe");
        utente.setNomeCompleto("John Doe");
        utente.setEmail("john.doe@example.com");
        utenteRepository.save(utente);

        // Esempio di prenotazione
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUtente(utente);
        prenotazione.setPostazione(postazione1);
        prenotazione.setGiornoprenotazione(LocalDate.now());
        prenotazioneRepository.save(prenotazione);

        Edificio edificio1 = new Edificio();
        edificio.setNome("Edificio B");
        edificio.setIndirizzo("Via Example, 123");
        edificio.setCitta("Città Example");
        edificioRepository.save(edificio);

        Postazione postazione2 = new Postazione();
        postazione1.setCodice("P002");
        postazione1.setDescrizione("Postazione Privata");
        postazione1.setTipoPostazione(TipoPostazione.OPENSPACE);
        postazione1.setNumeroMassimoOccupanti(1);
        postazione1.setEdificio(edificio);
        postazioneRepository.save(postazione2);

        Utente utente1 = new Utente();
        utente.setUsername("_doe");
        utente.setNomeCompleto("John cena");
        utente.setEmail("john.cena@example.com");
        utenteRepository.save(utente);

        // Esempio di prenotazione
        Prenotazione prenotazione1 = new Prenotazione();
        prenotazione.setUtente(utente);
        prenotazione.setPostazione(postazione1);
        prenotazione.setGiornoprenotazione(LocalDate.now());
        prenotazioneRepository.save(prenotazione1);

   // prenotazioneService.effettuaPrenotazione("John_doe",,LocalDate.of(2015,02,8));

    }
}

