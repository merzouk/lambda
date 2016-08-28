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
 * Fichier 		:	Facture.java
 * Cree le 		: 	27 ao�t 2016 � 18:48:33
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
 * @author  : admin
 * @project : web
 * @package : com.org.model
 * @date    : 27 ao�t 2016 18:48:33
 */
@Entity(name = "Facture")
@Table(name = "Facture")
public class Facture implements Serializable
{
   
   /**
    * 
    */
   private static final long serialVersionUID = 5038042808309960234L;
   
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer           id;
   
   @Column(name = "numeroFacture", length = 50, nullable = false, unique = true)
   private String            numeroFacture;
   
   @Column(name = "email", length = 150, nullable = false, unique = false)
   private String            email;
   
   @Column(name = "montant")
   private double            montant;
   
   @Column(name = "factureReglee")
   private boolean           factureReglee;
   
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
    * @return the numeroFacture
    */
   public String getNumeroFacture()
   {
      return numeroFacture;
   }
   
   /**
    * @param numeroFacture the numeroFacture to set
    */
   public void setNumeroFacture( String numeroFacture )
   {
      this.numeroFacture = numeroFacture;
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
    * @return the montant
    */
   public double getMontant()
   {
      return montant;
   }
   
   /**
    * @param montant the montant to set
    */
   public void setMontant( double montant )
   {
      this.montant = montant;
   }
   
   /**
    * @return the factureReglee
    */
   public boolean isFactureReglee()
   {
      return factureReglee;
   }
   
   /**
    * @param factureReglee the factureReglee to set
    */
   public void setFactureReglee( boolean factureReglee )
   {
      this.factureReglee = factureReglee;
   }
   
   /**
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString()
   {
      return "Facture [id=" + id + ", numeroFacture=" + numeroFacture + ", email=" + email + ", montant=" + montant + ", factureReglee=" + factureReglee + "]";
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
      result = prime * result + ( factureReglee ? 1231 : 1237 );
      result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
      long temp;
      temp = Double.doubleToLongBits( montant );
      result = prime * result + (int) ( temp ^ ( temp >>> 32 ) );
      result = prime * result + ( ( numeroFacture == null ) ? 0 : numeroFacture.hashCode() );
      return result;
   }
   
   /**
    * @see java.lang.Object#equals(java.lang.Object)
    */
   @Override
   public boolean equals( Object obj )
   {
      if( this == obj ) return true;
      if( obj == null ) return false;
      if( getClass() != obj.getClass() ) return false;
      Facture other = (Facture) obj;
      if( email == null )
      {
         if( other.email != null ) return false;
      }
      else if( !email.equals( other.email ) ) return false;
      if( factureReglee != other.factureReglee ) return false;
      if( id == null )
      {
         if( other.id != null ) return false;
      }
      else if( !id.equals( other.id ) ) return false;
      if( Double.doubleToLongBits( montant ) != Double.doubleToLongBits( other.montant ) ) return false;
      if( numeroFacture == null )
      {
         if( other.numeroFacture != null ) return false;
      }
      else if( !numeroFacture.equals( other.numeroFacture ) ) return false;
      return true;
   }
}
