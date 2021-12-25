package com.bilgeadam.localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalMessages {
    private final ResourceBundle messages;

    public LocalMessages() {
        this.messages = ResourceBundle.getBundle("messages"); //Resource bundle içindeki message klasörünü çağırıyoruz.

        System.out.println(messages.getString("intro")); //messages içindeki "intro" keyini çağırıyoruz.
    }

    public void printInfo(String key){
        System.out.println(messages.getString(key));
    }

    public void printInfo(String key, Locale locale){
        System.out.println(ResourceBundle.getBundle("messages", locale).getString(key));
    }

}

//Resources altında bundle klasöründe oluşturduğumuz 
//messages.properties(default) ve diğer dillerden otomatik bilgi çekiyor.
//".properties" java tarafından otomatik tanınıyor.
//istenen locale veri yok ise sistemin locale verisi (eğer var ise) ile döndürür.
