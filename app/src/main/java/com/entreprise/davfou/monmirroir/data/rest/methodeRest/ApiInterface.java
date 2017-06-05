package com.entreprise.davfou.monmirroir.data.rest.methodeRest;

/**
 * Created by davidfournier on 28/02/2017.
 */


import com.entreprise.davfou.monmirroir.data.rest.baseDeDonnee.model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface ApiInterface {
    public static final String ENDPOINT = "http://fournierdavid.fr/mirroir/";



    /*$nom 		= 	$_POST['nom'];
$prenom 	= 	$_POST['prenom'];
$age		= 	$_POST['age'];
$url1		= 	$_POST['url1'];
$meteo		= 	$_POST['meteo'];
*/


    //---------------------------------------------------------userMirroir------------------------------------------------------------//



     /**
     *  Création d'un user
     * @param nom
     * @param prenom
     * @param age
     * @param url1
     * @param meteo
     * @return result
     */
    @FormUrlEncoded
    @POST("create.php")
    Call<String> createUser(@Field("nom") String nom, @Field("prenom") String prenom, @Field("age") int age, @Field("url1") String url1, @Field("meteo") Boolean meteo);

    /**
     *  Update user
     * @param id
     * @param nom
     * @param prenom
     * @param age
     * @param url1
     * @param meteo
     * @return result
     */
    @FormUrlEncoded
    @POST("create.php")
    Call<String> updateUser(@Field("id") int id, @Field("nom") String nom, @Field("prenom") String prenom, @Field("age") int age, @Field("prenom") String url1, @Field("meteo") Boolean meteo);


    /**
     *  Connect user
     * @param nom
     * @param prenom
     * @return user
     */
    @FormUrlEncoded
    @POST("connect.php")
    Call<User> connectUser(@Field("nom") String nom, @Field("prenom") String prenom);




}