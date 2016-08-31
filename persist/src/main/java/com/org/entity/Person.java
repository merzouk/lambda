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
 * Fichier 		:	Person.java
 * Cree le 		: 	27 ao�t 2016 � 17:35:51
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A Renseigner.
 * @author  : mmenhour
 * @project : web
 * @package : com.org
 * @date    : 27 ao�t 2016 17:35:51
 */
@Entity(name = "Person")
@Table(name = "Person")
public class Person implements Serializable
{
   
   /**
    * 
    */
   private static final long serialVersionUID = 7297840248652526891L;
   
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer           id;
   
   @Column(name = "nom", length = 50, nullable = false, unique = false)
   private String            nom;
   
   @Column(name = "prenom", length = 50, nullable = false, unique = false)
   private String            prenom;
   
   @Column(name = "email", length = 150, nullable = false, unique = true)
   private String            email;
   
   /**
    * @return the id
    */
   public Integer getId()
   {
      return id;
   }
   
   /**
    * @param id the id to set
    */
   public void setId( Integer id )
   {
      this.id = id;
   }
   
   /**
    * @return the nom
    */
   public String getNom()
   {
      return nom;
   }
   
   /**
    * @param nom the nom to set
    */
   public void setNom( String nom )
   {
      this.nom = nom;
   }
   
   /**
    * @return the prenom
    */
   public String getPrenom()
   {
      return prenom;
   }
   
   /**
    * @param prenom the prenom to set
    */
   public void setPrenom( String prenom )
   {
      this.prenom = prenom;
   }
   
   /**
    * @return the email
    */
   public String getEmail()
   {
      return email;
   }
   
   /**
    * @param email the email to set
    */
   public void setEmail( String email )
   {
      this.email = email;
   }
   
   /**
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString()
   {
      return "Person [nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
   }
   
   /**
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ( ( email == null ) ? 0 : email.hashCode() );
      result = prime * result + ( ( nom == null ) ? 0 : nom.hashCode() );
      result = prime * result + ( ( prenom == null ) ? 0 : prenom.hashCode() );
      return result;
   }
   
   /**
    * @see java.lang.Object#equals(java.lang.Object)
    */
   @Override
   public boolean equals( Object obj )
   {
      if( obj == null ) return false;
      if( getClass() != obj.getClass() ) return false;
      if( ( (Person) obj ).getId() == null ) return false;
      Person other = (Person) obj;
      if( id == null )
      {
         if( other.id != null ) return false;
      }
      else if( !id.equals( other.id ) ) return false;
      return true;
   }
}