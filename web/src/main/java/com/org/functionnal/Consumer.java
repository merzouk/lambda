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
 * Fichier 		:	Consumer.java
 * Cree le 		: 	27 août 2016 à 18:24:37
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.functionnal;

/**
 * Consumer
 * To represent an operation that takes an argument and returns no result.
 * 
 * @author  : mmenhour
 * @project : web
 * @package : com.org
 * @date    : 27 août 2016 18:24:37
 */
@FunctionalInterface
public interface Consumer<T>
{
   public void accept( T t ) throws Exception;
}
