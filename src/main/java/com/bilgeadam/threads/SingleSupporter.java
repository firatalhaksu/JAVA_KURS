package com.bilgeadam.threads;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SingleSupporter {
    private static SingleSupporter INSTANCE;
    private final Date birthday;
    private final SimpleDateFormat format;

    private SingleSupporter() {
        birthday = new Date();
        format = new SimpleDateFormat("yyyy-MM-dd hh:ss:SSS Z");
    }

    public static synchronized SingleSupporter getInstance() {
        if (INSTANCE == null)
            INSTANCE = new SingleSupporter();

        return INSTANCE;
    }

    String getBirthday() {
        return format.format(birthday);
    }
}
