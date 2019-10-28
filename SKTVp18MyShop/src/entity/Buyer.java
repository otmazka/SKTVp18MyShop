/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Buyer implements Serializable{
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String name;
   private String Lastname;
   private int money;
   @Column(unique = true)
   private String email;

    public Buyer(int id, String name, String Lastname, int money, String email) {
        this.id = id;
        this.name = name;
        this.Lastname = Lastname;
        this.money = money;
        this.email = email;
    }

    public Buyer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Buyer{" + "name=" + name + ", Lastname=" + Lastname + ", money=" + money + ", email=" + email + '}';
    }
    
}
