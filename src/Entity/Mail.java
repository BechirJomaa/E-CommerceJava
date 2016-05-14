/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.util.Objects;



public class Mail {
    String mail;
    String password;
    String subject ;
    String contenu;

    public Mail() {
    }

    public Mail(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public String getContenu() {
        return contenu;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mail other = (Mail) obj;
        if (!Objects.equals(this.mail, other.mail)) {
            return false;
        }
        return true;
    }
    

    
}
