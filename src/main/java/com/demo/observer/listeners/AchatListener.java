package com.demo.observer.listeners;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.observer.enumeration.ETypeOperation;
import com.demo.observer.eventListener.EventListener;

/**
 * Listener des achats permettant 
 * de notifier l'utilisateur de l'achat
 * @author fidal
 *
 */
public class AchatListener implements EventListener {
	
	private ETypeOperation typeOperation;
	private Date dateAchatCommande;
	
	private Logger logger = LoggerFactory.getLogger(AchatListener.class);


	public AchatListener(ETypeOperation typeOperation, Date dateAchatCommande) {
		this.typeOperation = typeOperation;
		this.dateAchatCommande = dateAchatCommande;
	}

	@Override
	public void execute() {
		
		logger.info("Votre achat a été prise en compte, une autre message vous notifiera de l'envoie de la commande.");
	}

	public ETypeOperation getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(ETypeOperation typeOperation) {
		this.typeOperation = typeOperation;
	}

	public Date getDateAchatCommande() {
		return dateAchatCommande;
	}

	public void setDateAchatCommande(Date dateEnvoieCommande) {
		this.dateAchatCommande = dateEnvoieCommande;
	}

	
}
