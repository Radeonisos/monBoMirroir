package com.entreprise.davfou.monmirroir.model;

/**
 * Created by davidfournier on 06/05/2017.
 */

public class User {

    private int id;

    private String nom;

    private String prenom;

    private int age;

    private String url1;

    private Boolean meteo;


    public User(int id, String nom, String prenom, int age, String url1, Boolean meteo) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.url1 = url1;
        this.meteo = meteo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public Boolean getMeteo() {
        return meteo;
    }

    public void setMeteo(Boolean meteo) {
        this.meteo = meteo;
    }
}
