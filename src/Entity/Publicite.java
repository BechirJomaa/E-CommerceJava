/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.sql.Blob;
import java.sql.Date;
import org.apache.myfaces.custom.fileupload.UploadedFile;
/**
 *
 * @author Dridi
 */
public class Publicite {
    private int id;
    private String type ;
    private String sujet;
    private String lieu;
    private Date date;
    private Blob img;
    private UploadedFile uploadedFile;
    
    //**
    String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UploadedFile getUploadedFile() {
        
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
    

    public Publicite() {
    }

    public Blob getImg() {
        return img;
    }

    public void setImg(Blob image) {
        this.img = img;
    }

    public Publicite(String type, String sujet, String nom, String lieu, Date date, User user, Blob image) {
        this.type = type;
        this.sujet = sujet;
        this.lieu = lieu;
        this.date = date;
        this.img= img;
    }

    public Publicite(int id, String type, String sujet, String nom, String lieu, Date date, User user, Blob image) {
        this.id = id;
        this.type = type;
        this.sujet = sujet;
        this.lieu = lieu;
        this.date = date;
        this.img = img;
    }



    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }



    @Override
    public String toString() {
        return "Publicite{" + "id=" + id + ", type=" + type + ", sujet=" + sujet + ", lieu=" + lieu + ", date=" + date + ", img=" + img + ", uploadedFile=" + uploadedFile + ", url=" + url + '}';
    }


    
    
    
}
