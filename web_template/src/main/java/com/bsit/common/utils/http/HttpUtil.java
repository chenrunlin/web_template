package com.bsit.common.utils.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


public class HttpUtil
{
    public static String sendPost(String url, String data) throws Exception
    {
        URL localURL = new URL(url);
        URLConnection connection = localURL.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection)connection;
        
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        
        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;
        
        try
        {
            outputStream = httpURLConnection.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(outputStream);
            
            outputStreamWriter.write(data);
            outputStreamWriter.flush();
            
            if (httpURLConnection.getResponseCode() >= 300)
            {
                throw new Exception("HTTP Request is not success, Response code is "
                    + httpURLConnection.getResponseCode());
            }
            
            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            reader = new BufferedReader(inputStreamReader);
            
            while ((tempLine = reader.readLine()) != null)
            {
                resultBuffer.append(tempLine);
            }
        }
        finally
        {
            if (outputStreamWriter != null)
            {
                outputStreamWriter.close();
            }
            
            if (outputStream != null)
            {
                outputStream.close();
            }
            
            if (reader != null)
            {
                reader.close();
            }
            
            if (inputStreamReader != null)
            {
                inputStreamReader.close();
            }
            
            if (inputStream != null)
            {
                inputStream.close();
            }
        }
        
        return resultBuffer.toString();
    }
}
