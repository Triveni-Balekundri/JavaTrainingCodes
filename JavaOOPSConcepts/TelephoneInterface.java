package objectOrientedPrograms;

public interface TelephoneInterface {


	/*
	 * Features:
	 * 1.power on
	 * 2.dial a number
	 * 3.Answer the call
	 * 4.Call another phone
	 * 5.ringing notification
	 */
	
	//methods which are there in the interface
	void powerOn();
	void dialNumber(String phoneNumber);
	void answerCall();
	boolean callPhoneVerfication(String phoneNumber);
	boolean isRinging();

}
