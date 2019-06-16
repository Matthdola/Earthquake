package com.example.android.quakereport;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpHandler {
    private static final String TAG = HttpHandler.class.getSimpleName();

    public  HttpHandler(){

    }

    public String makeServiceCall(String reqUrl){
        String response = null;

        try {
            URL url = new URL(reqUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Read the response
            InputStream in  = new BufferedInputStream(conn.getInputStream());
            response = convertStreamToString(in);
        } catch (MalformedURLException e){
            Log.e(TAG, "MalformedURLException: " + e.getMessage());
        } catch (ProtocolException e){
            Log.e(TAG, "ProtocolException: " + e.getMessage());
        } catch (IOException e){
            Log.e(TAG, "IOException: " + e.getMessage());
        } catch (Exception e){
            Log.e(TAG, "Exception: " + e.getMessage());
        }

        return response;
    }

    private String convertStreamToString(InputStream in) {
        return "";
    }
}
