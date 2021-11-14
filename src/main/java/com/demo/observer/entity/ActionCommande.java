package com.demo.observer.entity;

import java.util.Date;

import com.demo.observer.enumeration.ETypeOperation;
import com.demo.observer.exception.EventNonDefiniDansEventManagerException;
import com.demo.observer.exception.TypeEventDifferentDeTypeListenerException;
import com.demo.observer.listeners.DispoEnMagasinListener;
import com.demo.observer.listeners.EnvoieCommandeListener;
import com.demo.observer.publisher.EventManager;

/**
 * Classe permettant de traiter les différentes action possible
 * @author fidal
 *
 */
public class ActionCommande {
	
	public EventManager eventManager;
	
	
	public ActionCommande() {
		this.eventManager = new EventManager(ETypeOperation.ACHETER,ETypeOperation.ENVOIE_COMMANDE,
				ETypeOperation.RESERVER,ETypeOperation.DISPO_MAGASIN);
	}

	public void notifierAchat(Date date) throws TypeEventDifferentDeTypeListenerException, EventNonDefiniDansEventManagerException {
		
		eventManager.notify(ETypeOperation.ACHETER, date);
		eventManager.subscribe(ETypeOperation.ENVOIE_COMMANDE, new EnvoieCommandeListener(ETypeOperation.ENVOIE_COMMANDE, date));

		
	}
	
	public void notifierEnvoieCommande(Date date) {
		
		eventManager.notify(ETypeOperation.ENVOIE_COMMANDE, date);
		
	}
	
	public void notifierReservation(Date date) throws TypeEventDifferentDeTypeListenerException, EventNonDefiniDansEventManagerException {
		
		eventManager.notify(ETypeOperation.RESERVER, date);
		eventManager.subscribe(ETypeOperation.DISPO_MAGASIN, new DispoEnMagasinListener(ETypeOperation.DISPO_MAGASIN, date));
		
	}
	
	public void notifierReceptionEnMagasin(Date date) {
		
		eventManager.notify(ETypeOperation.DISPO_MAGASIN, date);
		
	}
	

	
	

}
