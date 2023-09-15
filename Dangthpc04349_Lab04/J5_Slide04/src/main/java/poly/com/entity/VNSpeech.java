package poly.com.entity;

import org.springframework.stereotype.Component;

import poly.com.custom_interface.Speech;

@Component
public class VNSpeech implements Speech {

	@Override
	public String sayGreeString() {
		return "Xin chào đến với chương trình";
	}

}
