package com.abhi.hashing.practice.md5;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5_Sample {

    public static void main(String[] args){

        System.out.println("Application Started !!");
        // String to Hash
       // String passwordToGenerateHash = "Str0ngP@ssWoRD";
        String passwordToGenerateHash = "password";
        try {
            // Get Message Digest for Algorithm - MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // Add Password Bytes to Digest
            md.update(passwordToGenerateHash.getBytes());
            //Get the Hash's Byte
            byte[] hashByte = md.digest();
            // Converting Hash  from Decimal byte[] to Hexadecimal
            StringBuilder sb =new StringBuilder();
            for (byte b : hashByte) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
                // TODO - compare if this works too : sb.append(String.format("%02x", bytes[i]));
                // https://stackoverflow.com/questions/25838473/what-does-0xff-do-and-md5-structure
            }
            System.out.println("Hash Generated : " + sb.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


    }

}
