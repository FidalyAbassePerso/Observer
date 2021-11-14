package com.demo.observer.publisher;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.observer.enumeration.ETypeOperation;
import com.demo.observer.eventListener.EventListener;
import com.demo.observer.exception.EventNonDefiniDansEventManagerException;
import com.demo.observer.exception.TypeEventDifferentDeTypeListenerException;
import com.demo.observer.exception.utils.ExceptionUtils;
import com.demo.observer.listeners.AchatListener;
import com.demo.observer.listeners.DispoEnMagasinListener;
import com.demo.observer.listeners.EnvoieCommandeListener;
import com.demo.observer.listeners.ReservationListener;

/**
 * Objet Diffuseur permettant de souscrire un évènement,
 * supprimer une souscription,
 * notifier les différentes actions souscrites
 * @author fidal
 *
 */
public class EventManager {
	
	private Map<ETypeOperation,List<EventListener>> eventList = new HashMap<>();
	
	private Logger logger = LoggerFactory.getLogger(EventManager.class);

	public EventManager(ETypeOperation... operations) {
        for (ETypeOperation operation : operations) {
            this.eventList.put(operation, new ArrayList<>());
        }
    }
	
	/**
	 * Souscrire une action
	 * @param event action à souscrire
	 * @param eventListener listener de l'action à souscrire
	 * @throws TypeEventDifferentDeTypeListenerException si le paramètre event est différent du type du paramètre eventListener
	 * @throws EventNonDefiniDansEventManagerException si le paramètre event n'a pas été initialisé dans le constructeur de la classe
	 */
	public void subscribe(ETypeOperation event,EventListener eventListener) throws TypeEventDifferentDeTypeListenerException, EventNonDefiniDansEventManagerException {
		
		ExceptionUtils.verifierTypeOperationValide(event, eventList.values());

		ExceptionUtils.verifierCoherenceTypeEventAvecListener(event, eventListener);

		List<EventListener> listenerUsers = eventList.get(event);
		listenerUsers.add(eventListener);
		eventList.put(event,listenerUsers);
	}
	
	/**
	 * Supprimer une action souscrite
	 * @param event action à supprimer
	 * @param eventListener listener de l'action à supprimer
	 * @throws TypeEventDifferentDeTypeListenerException si le paramètre event est différent du type du paramètre eventListener
	 * @throws EventNonDefiniDansEventManagerException si le paramètre event n'a pas été initialisé dans le constructeur de la classe
	 */
	public void unsubscribe(ETypeOperation event,EventListener eventListener) throws TypeEventDifferentDeTypeListenerException, EventNonDefiniDansEventManagerException {
		//TODO Rajouter exception
		
		ExceptionUtils.verifierTypeOperationValide(event, eventList.values());

		ExceptionUtils.verifierCoherenceTypeEventAvecListener(event, eventListener);

		List<EventListener> listenerUsers = eventList.get(event);
		listenerUsers.remove(eventListener);
		eventList.put(event,listenerUsers);
	}
	
	/**
	 * Notifier une action souscrite à une date donnée
	 * @param event action souscrite
	 * @param date date de souscription
	 */
	public void notify(ETypeOperation event,Date date) {
		//TODO Rajouter exception
		List<EventListener> listenerUsers = eventList.get(event);
		
		for (EventListener eventListeners : listenerUsers) {
			
			if (event.equals(ETypeOperation.ACHETER)) {
				notifyAchat(eventListeners,date);
			}
			else if (event.equals(ETypeOperation.ENVOIE_COMMANDE)) {
				notifyEnvoieCommande(eventListeners,date);
			}
			else if (event.equals(ETypeOperation.RESERVER)) {
				notifyReservation(eventListeners,date);
			}
			else {
				notifyReceptionCommande(eventListeners,date);
			}
			//eventListeners.execute();
		}
	}
	
	private void notifyAchat(EventListener event,Date date) {
		AchatListener achatListener =  (AchatListener) event;
		
		if (achatListener.getDateAchatCommande().equals(date)) {
			event.execute();
		}
	}
	
	private void notifyEnvoieCommande(EventListener event,Date date) {
		EnvoieCommandeListener envoieCommandeListener =  (EnvoieCommandeListener) event;
		
		if (envoieCommandeListener.getDateEnvoie().equals(date)) {
			event.execute();
		}
	}
	
	private void notifyReservation(EventListener event,Date date) {
		ReservationListener reservationListener =  (ReservationListener) event;
		
		if (reservationListener.getDateReservation().equals(date)) {
			event.execute();
		}
	}
	
	private void notifyReceptionCommande(EventListener event,Date date) {
		DispoEnMagasinListener dispoEnMagasinListener =  (DispoEnMagasinListener) event;
		
		if (dispoEnMagasinListener.getDateReceptionEnMagasin().equals(date)) {
			event.execute();
		}
	}


	public Map<ETypeOperation, List<EventListener>> getEventList() {
		return eventList;
	}


	public void setEventList(Map<ETypeOperation, List<EventListener>> eventList) {
		this.eventList = eventList;
	}
	
	

}
