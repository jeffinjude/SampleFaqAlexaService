package samplefaq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.slu.Slot;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;

import dao.SampleFaqDao;

public class SampleFaqSpeechlet implements Speechlet {
	private static final Logger log = LoggerFactory.getLogger(SampleFaqSpeechlet.class);
	
	SampleFaqDao sampleFaqDao = new SampleFaqDao();
	String invalidSpeechText = "Sorry I could not find the answer for your query";
	
	public SpeechletResponse onIntent(IntentRequest request, Session session) throws SpeechletException {
        log.info("onIntent requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());

        Intent intent = request.getIntent();
        String intentName = (intent != null) ? intent.getName() : null;
        
//        if ("ForgotLoginIntent".equals(intentName)) {
//            return getForgotLoginIntentResponse();
//        }  
//        else if("ReportLossIntent".equals(intentName))
//        {
//        	return getReportLossIntentResponse();
//        }
//        else if("AMAZON.HelpIntent".equals(intentName))
//        {
//        	return getHelpIntentResponse();
//        }
//        else if("InvalidIntent".equals(intentName)){
//        	return getInvalidIntentResponse();
//        }
//        else {
//            throw new SpeechletException("Invalid Intent");
//        }
        
        switch(intentName){
        	case "ForgotLoginIntent" : return getForgotLoginIntentResponse(request,session);
        	case "ReportLossIntent" : return getReportLossIntentResponse(request,session);
        	case "AMAZON.HelpIntent" : return getHelpIntentResponse(request,session);
        	case "InvalidIntent" : return getInvalidIntentResponse(request,session);
        	default : throw new SpeechletException("Invalid Intent");
        }
	}

	public SpeechletResponse onLaunch(LaunchRequest request, Session session) throws SpeechletException {
		 log.info("onLaunch requestId={}, sessionId={}", request.getRequestId(),
	                session.getSessionId());
		return getWelcomeResponse();
	}

	public void onSessionEnded(SessionEndedRequest request, Session session) throws SpeechletException {
	}

	public void onSessionStarted(SessionStartedRequest request, Session session) throws SpeechletException {
	}
	
	private SpeechletResponse getWelcomeResponse() {
        String speechText = "Welcome to Sample FAQ App";

        // Create the Simple card content.
        SimpleCard card = new SimpleCard();
        card.setTitle("Welcome to Sample FAQ App");
        card.setContent(speechText);

        // Create the plain text output.
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        // Create reprompt
        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(speech);

        return SpeechletResponse.newAskResponse(speech, reprompt, card);
    }
	
    private SpeechletResponse getForgotLoginIntentResponse(IntentRequest request, Session session) {
//        String speechText = "Trying to log into your My Sample account, but can’t remember your username and password? Don’t worry; we can help recover your information, "
//        					+"First Go to the My Sample account recovery page, "
//        					+"Then Enter your policy number, last name, and date of birth, "
//        					+"After that Answer a security question, "
//        					+"Now you will Get your account information! ";

    	String speechText = sampleFaqDao.getFaqAnswer("ForgotLoginIntent");
    	
        SimpleCard card = new SimpleCard();
        card.setTitle("Account recovery steps.");
        card.setContent(speechText);

        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        return SpeechletResponse.newTellResponse(speech, card);
    }
    
    private SpeechletResponse getReportLossIntentResponse(IntentRequest request, Session session) {
//        String speechText = "After a car accident, home damage, or any kind of loss, it’s important to let your Sample agent know, "
//        					+"To get the claims process moving immediately though, call Sample Claim Services at 1-800-435-7764.";
    	String speechText = sampleFaqDao.getFaqAnswer("ReportLossIntent");
        
        SimpleCard card = new SimpleCard();
        card.setTitle("Who should I call to report a loss?");
        card.setContent(speechText);

        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        return SpeechletResponse.newTellResponse(speech, card);
    }
    
    private SpeechletResponse getHelpIntentResponse(IntentRequest request, Session session) {
        String speechText = "Hello there, you could ask me about Sample Insurance Claims!";

        SimpleCard card = new SimpleCard();
        card.setTitle("Hello there, you could ask me about Sample Insurance Claims!");
        card.setContent(speechText);

        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText); 

        return SpeechletResponse.newTellResponse(speech, card);
    }
    
    private SpeechletResponse getInvalidIntentResponse(IntentRequest request, Session session) {
    	String speechText = invalidSpeechText;

        SimpleCard card = new SimpleCard();
        card.setTitle(invalidSpeechText);
        card.setContent(speechText);

        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText); 

        return SpeechletResponse.newTellResponse(speech, card);
    }
}
