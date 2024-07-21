package objectOrientedPrograms;

public class LandPhoneClass implements TelephoneInterface {

	private String myNumber;
	private boolean isRinging;
	
	public LandPhoneClass(String myNumber)
	{
		this.myNumber=myNumber;
	}

	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("Land Line is always powered");
	}

	public void dialNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		System.out.println("Calling the number: "+phoneNumber+" on land Line");
		
	}

	public void answerCall() {
		// TODO Auto-generated method stub
		if(isRinging)
		{
			System.out.println("Answering/picked up for answering the Land-Line phone");
			isRinging=false;
		}
		else
		{
			System.out.println("The phone is not ringing");
		}
	}

	public boolean callPhoneVerfication(String phoneNumber) {
		// TODO Auto-generated method stub
	
		if(phoneNumber==myNumber)
		{
			isRinging=true;
			System.out.println("Phone ringing verified");
			
		}
		else
		{
			isRinging =false;
		}
		
		return isRinging;
	}


	public boolean isRinging() {
		// TODO Auto-generated method stub
		return isRinging;
	}

}
