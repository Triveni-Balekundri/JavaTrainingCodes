package objectOrientedPrograms;

public class MainClassForInterfaceConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		LandLineClass myPhone = new LandLineClass("8050436720");
//		myPhone.powerOn();
//		myPhone.callPhoneVerfication("8050436720");
//		myPhone.answerCall();

		MobileClass mobile = new MobileClass("123456");
//		mobile.powerOn();
		mobile.callPhoneVerfication("12345");
		mobile.answerCall();


	}

}
