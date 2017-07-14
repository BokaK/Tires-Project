package mk.ukim.finki.tires.config;

/**
 * Created by user on 14.7.2017.
 */


import com.sparkpost.Client;
import com.sparkpost.exception.SparkPostException;

public class EmailNotification {

    public static void main(String[] args) throws SparkPostException {
        String API_KEY = "abad598070944426b5525a71aee1c150bd219f97";
        Client sparky = new Client(API_KEY);

        sparky.sendMessage(
                "testing@sparkpostbox.com",
                "kabranova.boka@yahoo.com",
                "Sakam gumi!",
                "Uspeshna narachka!",
                "<p>Uspeshna narachka</p>");
    }
}