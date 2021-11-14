package com.demo.observer;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.observer.entity.ActionCommande;
import com.demo.observer.enumeration.ETypeOperation;
import com.demo.observer.exception.EventNonDefiniDansEventManagerException;
import com.demo.observer.exception.TypeEventDifferentDeTypeListenerException;
import com.demo.observer.listeners.AchatListener;
import com.demo.observer.listeners.ReservationListener;

@SpringBootApplication
public class ObserverApplication {

	public static void main(String[] args) throws TypeEventDifferentDeTypeListenerException, EventNonDefiniDansEventManagerException {
		SpringApplication.run(ObserverApplication.class, args);
		
		ActionCommande actionCommande = new ActionCommande();
		
		Date date =  new Date();
		
		actionCommande.eventManager.subscribe(ETypeOperation.ACHETER, new AchatListener(ETypeOperation.ACHETER, date));
		
		actionCommande.eventManager.subscribe(ETypeOperation.RESERVER, new ReservationListener(ETypeOperation.RESERVER, date));

		actionCommande.notifierAchat(date);
		
		actionCommande.notifierEnvoieCommande(date);
		
		actionCommande.notifierReservation(date);
		
		actionCommande.notifierReceptionEnMagasin(date);

	}

}
