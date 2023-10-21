package com.commerz.dvadnyvtahu.ai.service;

import com.commerz.dvadnyvtahu.ai.client.dto.ChatMessage;
import com.commerz.dvadnyvtahu.ai.client.midjourney.ImageRequest;
import com.commerz.dvadnyvtahu.ai.client.midjourney.Response;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class PromptOrchestrationService {

    @Autowired
    private ChatService chatService;

    @Autowired
    private MidJourneyService midJourneyService;

    private static final String STYLE = "In a very photorealistic style";
    private static final String FLAGS = "--stylize 1 --iw 1.2";

    private static final String CHATGPT_INSTRUCTION_TEMPLATE =
        "Develop a brief six-line description of a %s scenery portraying " + // scenery
        "a %s." + // gender
        "Portray the person just as \"person\". The language used should be simple with short sentences, " +
        "similar to a reading-level vocabulary.";

    @SneakyThrows
    public void generateImage(String photoUrl, String gender, String rawPrompt) {
        String instruction = String.format(CHATGPT_INSTRUCTION_TEMPLATE, rawPrompt, gender);
        ChatMessage chatGptResponse = chatService.prompt(instruction);
        String rawMjPrompt = chatGptResponse.getContent();
        // clear extra whitespaces
        String textPromptForMJ = rawMjPrompt.replace("/[\r\n/]+g", "");
        String finalPromptForMJ = String.format("%s %s %s::100 %s",
                photoUrl,
                STYLE,
                textPromptForMJ,
                FLAGS);

        ImageRequest ir = new ImageRequest();
        ir.setMsg(finalPromptForMJ);

        Response mjResponse = midJourneyService.callMidJourney(ir);

        HttpURLConnection connection =  (HttpURLConnection) new URL(mjResponse.getImageUrl()).openConnection();
        connection.connect();
        BufferedImage image = ImageIO.read(connection.getInputStream());
        connection.disconnect();

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyymmdd_hhmmss");
        String strDate = dateFormat.format(date);

        String filename = String.format("collabothon_output_%s", strDate);
        File outputFile = new File(String.format("C:\\temp\\%s.jpg", filename));

        ImageIO.write(image, "jpg", outputFile);
    }

}
