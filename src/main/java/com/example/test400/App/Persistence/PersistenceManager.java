package com.example.test400.App.Persistence;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import com.example.test400.Domein.Blog.Blog;
import com.example.test400.Domein.Oefening;
import com.example.test400.Domein.Tips.Tips;


import java.io.*;

public class PersistenceManager {

    private static String ENDPOINT = "https://ipasstorageaccount.blob.core.windows.net/";
    private static String SASTOKEN = "?sv=2021-06-08&ss=bfqt&srt=sco&sp=rwdlacupitfx&se=2022-08-01T19:16:22Z&st=2022-07-01T11:16:22Z&spr=https,http&sig=%2FqKAnxbguIe2IRE3fVEUAfT%2BTEik5vHLEN%2F7aZgk1KY%3D";
    private static String CONTAINER = "ipascontainer";


    private static BlobContainerClient blobContainerClient = new BlobContainerClientBuilder()
            .endpoint(ENDPOINT)
            .sasToken(SASTOKEN)
            .containerName(CONTAINER)
            .buildClient();


    public static void loadFromAzure() throws IOException, ClassNotFoundException {
        if (blobContainerClient.exists()) {
            BlobClient blobClientBlog = blobContainerClient.getBlobClient("blog_blob");

            if (blobClientBlog.exists()) {

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                blobClientBlog.download(baos);

                ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                ObjectInputStream ois = new ObjectInputStream(bais);


                Blog geladeBlog = (Blog) ois.readObject();
                Blog.setBlog(geladeBlog);

                baos.close();
                ois.close();
            }
        } else {
            throw new IllegalStateException("Tips niet gevonden ....");
        }
    }


    public static void saveFromAzure() throws IOException {
        if (!blobContainerClient.exists())
            blobContainerClient.create();

        BlobClient blobClientBlog = blobContainerClient.getBlobClient("blog_blob");
        Blog blogToSave = Blog.getBlog();


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        //hier kan iets fout gaan:
        oos.writeObject(blogToSave);

        byte[] bytez = baos.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(bytez);
        blobClientBlog.upload(bais, bytez.length, true);

        oos.close();
        bais.close();

    }
}
