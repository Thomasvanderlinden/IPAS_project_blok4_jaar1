//package com.example.test400;
//
//import com.azure.storage.blob.BlobClient;
//import com.azure.storage.blob.BlobContainerClient;
//import com.azure.storage.blob.BlobContainerClientBuilder;
//import com.example.test400.Domein.Oefening;
//import com.sun.mail.iap.ByteArray;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//
//public class PersistentieManager {
//    private final static String ENDPOINT = "https://ipasproject.blob.core.windows.net/";
//    private final static String SASTOKEN = "?sv=2021-06-08&ss=bfqt&srt=sco&sp=rwdlacupitfx&se=2022-08-06T21:54:12Z&st=2022-06-19T13:54:12Z&spr=https&sig=ylENLoETWAKxphjDMR%2BaOud4nhBGj12E%2FxS%2B7j2Wjq4%3D";
//    private final static String CONTAINER = "ipasproject"; // weetniezeker
//
//    private static BlobContainerClient blobContainer = new BlobContainerClientBuilder()
//            .endpoint(ENDPOINT)
//            .sasToken(SASTOKEN)
//            .containerName(CONTAINER)
//            .buildClient();
//
//    public void iets() throws IOException, ClassNotFoundException {
//        if(blobContainer.exists()){
//            BlobClient blob = blobContainer.getBlobClient("ipasproject");
//            if(blob.exists()){
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                blob.download(baos);
//
//                ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
//
//                ObjectInputStream ois = new ObjectInputStream(bais);
//
//                Oefening geladeOefening = (Oefening) ois.readObject();
//
//            }
//        }
//    }
//
//
//}
//
