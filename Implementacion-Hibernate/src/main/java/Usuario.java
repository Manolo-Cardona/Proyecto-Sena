package com.ejemplo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "usuario")
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_usuario")
  private int userID;

  @Column(name = "nombre_usuario")
  private String userName;

  @Column(name = "apellido_usuario")
  private String userLastName;

  @Column(name = "documento_usuario")
  private int userIDCard;

  @Column(name = "correo_electronico_usuario")
  private String userEmail;

  public Usuario() {
    // Constructor vacío requerido por Hibernate
  }

  public Usuario(String userName, String userLastName, int userIDCard, String userEmail) {
    this.userName = userName;
    this.userLastName = userLastName;
    this.userIDCard = userIDCard;
    this.userEmail = userEmail;
  }

  public int getUserID() {
    return userID;
  }

  public void setUserID(int userID) {
    this.userID = userID;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserLastName() {
    return userLastName;
  }

  public void setUserLastName(String userLastName) {
    this.userLastName = userLastName;
  }

  public int getUserIDCard() {
    return userIDCard;
  }

  public void setUserIDCard(int userIDCard) {
    this.userIDCard = userIDCard;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  @Override
  public String toString() {
    return "Usuario [userID=" + userID + ", userName=" + userName + ", userLastName=" + userLastName + ", userIDCard=" + userIDCard + ", userEmail=" + userEmail + "]";
  }
}

