package com.demo.observer.listeners;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.observer.enumeration.ETypeOperation;
import com.demo.observer.eventListener.EventListener;

/**
 * Listener de la disponibilité en magasin permettant 
 * de notifier l'utilisateur de la reception en magasin 
 * de la reservation
 * @author fidal
 *
 */
public class DispoEnMagasinListener implements EventListener {
	
	
	private ETypeOperation typeOperation;
	private Date dateReceptionEnMagasin;
	
	private Logger logger = LoggerFactory.getLogger(DispoEnMagasinListener.class);

	public DispoEnMagasinListener(ETypeOperation typeOperation, Date dateReceptionEnMagasin) {
		this.typeOperation = typeOperation;
		this.dateReceptionEnMagasin = dateReceptionEnMagasin;
	}

	@Override
	public void execute() {
		logger.info("Bonjour , votre commande est disponible en magasin, "
				+ "vous pouvez la récupérer dès aujourd'hui!");
		
	}

	public ETypeOperation getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(ETypeOperation typeOperation) {
		this.typeOperation = typeOperation;
	}

	public Date getDateReceptionEnMagasin() {
		return dateReceptionEnMagasin;
	}

	public void setDateReceptionEnMagasin(Date dateReceptionEnMagasin) {
		this.dateReceptionEnMagasin = dateReceptionEnMagasin;
	}
	
	

}
