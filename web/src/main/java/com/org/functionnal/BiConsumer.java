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
 * Fichier 		:	BiConsumer.java
 * Cree le 		: 	27 août 2016 à 18:25:11
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.functionnal;

import com.org.exception.FunctionnalException;

/**
 * BiConsumer
 * To represent an operation that takes two arguments and returns no result.
 * 
 * @author  : admin
 * @project : web
 * @package : com.org
 * @date    : 27 août 2016 18:25:11
 */
@FunctionalInterface
public interface BiConsumer<T, U>
{
   public void accept( T t, U u ) throws FunctionnalException;
}
