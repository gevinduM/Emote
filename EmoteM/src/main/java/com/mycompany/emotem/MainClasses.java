/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.emotem;

import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.Document.Type;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Sentiment;
import java.io.IOException;

/**
 *
 * @author Gevindu
 */
public class MainClasses {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try (LanguageServiceClient language = LanguageServiceClient.create()) {

      // The text to analyze
      String text = "Hello, world!";
      Document doc = Document.newBuilder()
          .setContent(text).setType(Type.PLAIN_TEXT).build();

      // Detects the sentiment of the text
      Sentiment sentiment = language.analyzeSentiment(doc).getDocumentSentiment();

      System.out.printf("Text: %s%n", text);
      System.out.printf("Sentiment: %s, %s%n", sentiment.getScore(), sentiment.getMagnitude());
    }catch(Exception e){
    
            System.out.println("Error "+e.getMessage());
    }
    }
    
}
