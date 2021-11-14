package com.demo.observer.exception.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.demo.observer.enumeration.ETypeOperation;
import com.demo.observer.eventListener.EventListener;
import com.demo.observer.exception.EventNonDefiniDansEventManagerException;
import com.demo.observer.exception.TypeEventDifferentDeTypeListenerException;
import com.demo.observer.listeners.AchatListener;
import com.demo.observer.listeners.DispoEnMagasinListener;
import com.demo.observer.listeners.EnvoieCommandeListener;
import com.demo.observer.listeners.ReservationListener;

public class ExceptionUtils {
	
	public static void verifierCoherenceTypeEventAvecListener(ETypeOperation typeOperation,EventListener eventListener) throws TypeEventDifferentDeTypeListenerException {
		if (typeOperation == null || eventListener == null) {
			throw new IllegalArgumentException("un argument null n'est pas autorisé");
		}
		else if (typeOperation.equals(ETypeOperation.ACHETER) && !(eventListener instanceof AchatListener)) {
			throw new TypeEventDifferentDeTypeListenerException("Le Listener affecté à l'opération acheter doit être de type AchatListener");
		}
		else if (typeOperation.equals(ETypeOperation.ENVOIE_COMMANDE) && !(eventListener instanceof EnvoieCommandeListener)) {
			throw new TypeEventDifferentDeTypeListenerException("Le Listener affecté à l'opération envoie commande doit être de type EnvoieCommandeListener");
		}
		else if (typeOperation.equals(ETypeOperation.RESERVER) && !(eventListener instanceof ReservationListener)) {
			throw new TypeEventDifferentDeTypeListenerException("Le Listener affecté à l'opération envoie commande doit être de type ReservationListener");
		}
		else if (typeOperation.equals(ETypeOperation.DISPO_MAGASIN) && !(eventListener instanceof DispoEnMagasinListener)) {
			throw new TypeEventDifferentDeTypeListenerException("Le Listener affecté à l'opération envoie commande doit être de type DispoEnMagasinListener");
		}
	}
	
	public static void verifierTypeOperationValide(ETypeOperation typeOperation, Collection<List<EventListener>> collection) throws EventNonDefiniDansEventManagerException {
		if (!collection.contains(typeOperation)) {
			throw new EventNonDefiniDansEventManagerException("L'opération "+typeOperation.getOperation()+" n'a pas été initialisé dans l'EventManager");
		}
	}
}
