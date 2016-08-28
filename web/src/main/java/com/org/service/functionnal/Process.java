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
 * Fichier 		:	Process.java
 * Cree le 		: 	27 août 2016 à 18:22:06
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.service.functionnal;

/**
 * A Renseigner.
 * @author  : admin
 * @project : web
 * @package : com.org
 * @date    : 27 août 2016 18:22:06
 */
@FunctionalInterface
public interface Process
{
   <T> void process( T[] list );
}
