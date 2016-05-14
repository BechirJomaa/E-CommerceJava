/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Dridi
 */
public class User {

    private int id;
    private String username;
    private String email;
    private String username_canonical;
    private String email_canonical;
    private String password;
    private String salt;
    private boolean enabled;
    private boolean locked;
    private String roles;
    private Favoris favoris;
    private Panier panier ;

    public Favoris getFavoris() {
        return favoris;
    }

    public void setFavoris(Favoris favoris) {
        this.favoris = favoris;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }
    

    public String getEmail() {
        return email;
    }

    public String getUsername_canonical() {
        return username_canonical;
    }

    public void setUsername_canonical(String username_canonical) {
        this.username_canonical = username_canonical;
    }

    public String getEmail_canonical() {
        return email_canonical;
    }

    public void setEmail_canonical(String email_canonical) {
        this.email_canonical = email_canonical;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
    
    
    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public User() {
    }

    public User(int id, String username, String email, String password, String salt) {
        this.id = id;
        this.username = username;

        this.email = email;

        this.password = password;
        this.salt = salt;
    }

    public User(String username, String email, String password, String salt) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", password=" + password + ", username=" + username + ", salt=" + salt + '}';
    }

}
