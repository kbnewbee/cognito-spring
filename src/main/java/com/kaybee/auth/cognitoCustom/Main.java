//package com.kaybee.auth.cognitoCustom;
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class Main {
//  public static void main(String[] args) {
//    String urlString = "https://alpha-trunk.dash-radixhealth.com/dash";
//    String regex1 = "/dash$";
//    System.out.println(urlString.replaceAll(regex1, ""));
//
//    // Regular expression to extract the domain
//    String regex = "^(?:https?://)?(?:www\\.)?([^/]+)";
//
//    // Compile the regular expression
//    Pattern pattern = Pattern.compile(regex);
//    Matcher matcher = pattern.matcher(urlString);
//
//    if (matcher.find()) {
//      // Extract the full host
//      String fullHost = matcher.group(1);
//      System.out.println(urlString);
//
//      // Further processing to extract the main domain
//      String mainDomain = extractMainDomain(fullHost);
//
//      System.out.println("Main domain: " + mainDomain);
//    } else {
//      System.out.println("No match found");
//    }
//  }
//
//  private static String extractMainDomain(String host) {
//    // Split the hostname by dots
//    String[] parts = host.split("\\.");
//
//    // Extract the main domain (second and top-level domain)
//    // This assumes the main domain is always the last two parts
//    if (parts.length >= 2) {
//      return parts[parts.length - 2] + "." + parts[parts.length - 1];
//    } else {
//      return "Invalid host";
//    }
//  }
//}