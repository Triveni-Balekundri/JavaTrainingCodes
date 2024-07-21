package objectOrientedPrograms;

public class MobileClass implements TelephoneInterface {

	private String myNumber;
	private boolean isRinging;
	private boolean isPowerOn;
	

	public MobileClass(String myNumber)
	{
		this.myNumber=myNumber;
	}


	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("Land Line is always powered");
	}


	@Override
	public void dialNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		System.out.println("Calling the number: "+phoneNumber+" on land Line");
	}


	@Override
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


	@Override
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


	@Override
	public boolean isRinging() {
		// TODO Auto-generated method stub
		return isRinging;
	}


}
