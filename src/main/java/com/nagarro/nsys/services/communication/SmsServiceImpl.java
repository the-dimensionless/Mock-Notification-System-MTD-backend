package com.nagarro.nsys.services.communication;

import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class SmsServiceImpl implements SMSService {
	
    public static final String ACCOUNT_SID = "*******************************";
    public static final String AUTH_TOKEN = "********************************";

    @Override
    public Message sendSMS(Long number, String body) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+91"+number.toString()),//The phone number you are sending text to
                new com.twilio.type.PhoneNumber("+12029337281"),//The Twilio phone number
                body)
           .create();

        return message;
    }
}
