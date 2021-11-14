package com.demo.observer.listeners;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.observer.enumeration.ETypeOperation;
import com.demo.observer.eventListener.EventListener;

/**
 * Listener de l'envoie de la commande permettant 
 * de notifier l'utilisateur de l'envoie après achat
 * @author fidal
 *
 */
public class EnvoieCommandeListener implements EventListener{
	
	private ETypeOperation typeOperation;
	private Date dateEnvoie;
	
	private Logger logger = LoggerFactory.getLogger(EnvoieCommandeListener.class);
	
	
	
	public EnvoieCommandeListener(ETypeOperation typeOperation, Date dateEnvoie) {
		this.typeOperation = typeOperation;
		this.dateEnvoie = dateEnvoie;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		logger.info("Votre commande a été envoyé, vous la recevrez d'ici 7 jours. Vous pouvez suivre votre commande sur la site du distributeur.");
	}
	
	public ETypeOperation getTypeOperation() {
		return typeOperation;
	}
	
	public void setTypeOperation(ETypeOperation typeOperation) {
		this.typeOperation = typeOperation;
	}

	public Date getDateEnvoie() {
		return dateEnvoie;
	}

	public void setDateEnvoie(Date dateEnvoie) {
		this.dateEnvoie = dateEnvoie;
	}


}
