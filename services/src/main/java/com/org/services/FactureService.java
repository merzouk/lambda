/*
 *--------------------------------------------------------
 * Administrateur
 *--------------------------------------------------------
 * Project     : web
 *
 * Copyright Administrateur,  All Rights Reserved.
 *
 * This software is the confidential and proprietary
 * information of Administrateur.
 * You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms
 * of the license agreement you entered into with
 * Administrateur.
 *-------------------------------------------------------- 
 * 
 * Fichier 		:	FactureService.java
 * Cree le 		: 	28 ao�t 2016 � 11:42:07
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.services;

import com.org.entity.Facture;

/**
 * A Renseigner.
 * @author  : admin
 * @project : web
 * @package : com.org.service
 * @date    : 28 ao�t 2016 11:42:07
 */
public interface FactureService
{
   /**
    * 
    * @param id
    * @return
    */
   Facture findById( Integer id );
   
   /**
    * 
    * @param persistenceUnit
    */
   public void setPersistenceUnit( String persistenceUnit );
   
   /**
    * @param dbName the dbName to set
    */
   public void setDbName( String dbName );
}
