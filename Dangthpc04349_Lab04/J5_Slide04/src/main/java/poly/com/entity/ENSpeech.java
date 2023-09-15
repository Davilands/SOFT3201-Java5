package poly.com.entity;

import org.springframework.stereotype.Component;

import poly.com.custom_interface.Speech;

@Component
public class ENSpeech implements Speech{

	@Override
	public String sayGreeString() {
		return "Hello guys!";
	}

}
