package com.blanchisserie.blanchisseriemoderne;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Send an SMS message directly by calling HTTP endpoint.
 *
 * THIS CODE EXAMPLE IS READY BY DEFAULT. HIT RUN TO SEND THE MESSAGE!
 *
 * Send SMS API reference: https://www.infobip.com/docs/api#channels/sms/send-sms-message
 * See Readme file for details.
 */
import okhttp3.*;

import java.io.IOException;

public class SendMessage {

    static final String BASE_URL = "https://rgqvpm.api.infobip.com";
    private static final String API_KEY = "App 62777fe068ddd4e369dbe0078e4af3c5-dc1888f0-db14-4b9f-bdc2-59dcfa55a03a";
    private static final String MEDIA_TYPE = "application/json";

    private static final String SENDER = "InfoSMS";

    public static void sendMessage(String recipient, String message) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        String bodyJson = String.format("{\"messages\":[{\"from\":\"%s\",\"destinations\":[{\"to\":\"%s\"}],\"text\":\"%s\"}]}",
                SENDER,
                recipient,
                message
        );

        MediaType mediaType = MediaType.parse(MEDIA_TYPE);
        RequestBody body = RequestBody.create(bodyJson, mediaType);

        Request request = prepareHttpRequest(body);
        Response response = client.newCall(request).execute();

        System.out.println("HTTP status code: " + response.code());
        System.out.println("Response body: " + response.body().string());
    }

    private static Request prepareHttpRequest(RequestBody body) {
        return new Request.Builder()
                .url(String.format("%s/sms/2/text/advanced", BASE_URL))
                .method("POST", body)
                .addHeader("Authorization", API_KEY)
                .addHeader("Content-Type", MEDIA_TYPE)
                .addHeader("Accept", MEDIA_TYPE)
                .build();
    }
}