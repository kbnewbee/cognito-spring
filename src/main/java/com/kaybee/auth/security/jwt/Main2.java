package com.kaybee.auth.security.jwt;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main2 {

  public static void main(String[] args) {
    // 12-9-1997

    Date date = new Date();
    System.out.println(date);

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");

    String format = simpleDateFormat.format(date);
    System.out.println(format);

  }

}
