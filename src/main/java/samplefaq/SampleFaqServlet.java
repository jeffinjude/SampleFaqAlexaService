package samplefaq;

import javax.servlet.annotation.WebServlet;

import com.amazon.speech.speechlet.servlet.SpeechletServlet;

@WebServlet("/samplefaq")
public class SampleFaqServlet extends  SpeechletServlet{
	
	public SampleFaqServlet() {
	    this.setSpeechlet(new SampleFaqSpeechlet());
	  }

}
