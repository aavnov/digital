package com.example.licensecheck.http_request;


import android.os.AsyncTask;

import com.example.licensecheck.Entity.Request;
import com.example.licensecheck.provider.ApplicationContextProvider;
import com.example.licensecheck.Entity.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.example.licensecheck.Entity.ListUsers;

import org.restlet.Client;
import org.restlet.Context;
import org.restlet.data.Protocol;
import org.restlet.resource.ClientResource;

//import org.restlet.engine.connector.HttpClientHelper;


public class HttpRequestTaskGetLicense extends AsyncTask<String, Void, ListUsers> {

    android.content.Context context = ApplicationContextProvider.getContext();

    String ipAddress = "52.0.57.170";

    //Client myClient = new Client(Protocol.HTTP);
//    Client restletClient = new Client(new Context(), Protocol.HTTP);
  //  String resourceRef = "http://" + ipAddress.getIpAddress() + ":8080/rest/clndrempl";

    Client restletClient = new Client(new Context(), Protocol.HTTPS);
    //String resourceRef = "https://" + ipAddress.getIpAddress() + ":8080/rest/clndrempl";
    //String resourceRef = "http://" + ipAddress + "/headers";

    //String resourceRef = "http://httpbin.org/get";

    String resourceRef = "https://reqres.in/api/users?page=2";






    @Override
    protected ListUsers doInBackground(String... params) {

        //Engine.getInstance().getRegisteredClients().clear();
        //Engine.getInstance().getRegisteredClients().add(new org.restlet.ext.nio.HttpClientHelper(null));
        //Engine.getInstance().getRegisteredClients().add(0, new org.restlet.ext.jetty.HttpClientHelper(null));
        //Engine.getInstance().getRegisteredClients().add(new org.restlet.ext.nio.HttpsClientHelper(null));

//        SslUp sslUp = new SslUp();
  //      Client restletClient = sslUp.SslUp(restletClient);

//        restletClient.getContext().getAttributes().put("sslContextFactory", (new SslUp()).SSlContextFactory());
  //      restletClient.getContext().getAttributes().put("hostnameVerifier",  (new SslUp()).HostNameVerifier());

        ClientResource clientResource = new ClientResource(resourceRef);

        //clientResource.getContext().getAttributes().put("sslContextFactory", sslContextFactory);
        //clientResource.getContext().getAttributes().put("sslContextFactory", sslContext);



        //clientResource.setRequestEntityBuffering(true);//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        clientResource.accept(org.restlet.data.MediaType.APPLICATION_JSON);
        clientResource.setNext(restletClient);

//        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
 //       Boolean sexClientPreference = prefs.getBoolean("sexClientPreference", true);
//        if(sexClientPreference == true) clientResource.setQueryValue("sexClient", context.getResources().getString(R.string.male));
  //      else                            clientResource.setQueryValue("sexClient", context.getResources().getString(R.string.female));

//        String androidId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
  //      clientResource.setQueryValue("androidId", androidId);


        String name = params[0];
        String inn  = params[1];
        String ogrn = params[2];
        String activity_type = params[3];
        String address = params[4];
        String date_register = params[5];
        String date_termination =params[6];


        clientResource.setQueryValue("page", name);
        clientResource.setQueryValue("inn", inn);

        System.out.println("!!!!!!!!!!!!!!!!!! ogrn = " + name);
        clientResource.setQueryValue("orgn", ogrn);

        clientResource.setQueryValue("activity_type", activity_type);
        clientResource.setQueryValue("address", address);
        clientResource.setQueryValue("date_register", date_register);
        clientResource.setQueryValue("date_termination", date_termination);



        String response = null;
        try {
            Boolean catch1;

            do{//проверяем response на вшивость
                try{response = clientResource.get().getText();
System.out.println("!!!!!!!!!! HttpRequestTaskGetHours: response  = " + response) ;
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
                    mapper.readValue(response, ListUsers.class);
                    catch1 = false;}
                catch (JsonParseException e) {
                    catch1 = true;
                }
            }while(catch1.equals(true));//проверили


            ObjectMapper  mapJsonToObject = new ObjectMapper();
           // mapJsonToObject.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            ListUsers inets = mapJsonToObject.readValue(response, ListUsers.class);

/*
            for (int i = 0; i < inets.length; i++) {
                for (int j = 0; j < inets[0].length; j++) {
System.out.println("!!!!!!!!!!  HttpRequestTaskGetEmpls: inets["+i+"]["+j+"] = " +inets[i][j].getName());
                }
            }
*/
            return inets;
        }catch(Exception e) {e.printStackTrace();}

        return null;
    }




    @Override
    protected void onPostExecute(ListUsers listUsers) {
        //arrayListUsers = arrayListUsers1;
        //String  length = inet1.toString();
        System.out.println(" !!!!!!!!!!!!!!!!!!! listUsers.page = " + listUsers.page);//getHeaders().getDate());
        System.out.println(" !!!!!!!!!!!!!!!!!!! listUsers.per_page = " + listUsers.per_page);//getHeaders().getDate());
        System.out.println(" !!!!!!!!!!!!!!!!!!! listUsers.total = " + listUsers.total);//getHeaders().getDate());
        System.out.println(" !!!!!!!!!!!!!!!!!!! listUsers.total_pages = " + listUsers.total_pages);//getHeaders().getDate());


        for (Data data  : listUsers.data) {
            System.out.println("                     ");//
            System.out.println(" !!!!!!!!!!!!!!!!!!! data.id         = " + data.id);//getHeaders().getDate());
            System.out.println(" !!!!!!!!!!!!!!!!!!! data.email      = " + data.email);//getHeaders().getDate());
            System.out.println(" !!!!!!!!!!!!!!!!!!! data.first_name = " + data.first_name);//getHeaders().getDate());
            System.out.println(" !!!!!!!!!!!!!!!!!!! data.last_name  = " + data.last_name);//getHeaders().getDate());
            System.out.println(" !!!!!!!!!!!!!!!!!!! data.avatar     = " + data.avatar);//getHeaders().getDate());
            System.out.println("                     ");//
        }
    }

/*    // Copy an InputStream to a File.
    private void copyInputStreamToFile(InputStream keystoreIS, File keystore) {
        try {
            byte[] buffer = new byte[keystoreIS.available()];
            keystoreIS.read(buffer);

            OutputStream outStream = new FileOutputStream(keystore);
            outStream.write(buffer);
        }catch (IOException e) {e.printStackTrace();}
    }*/


}
