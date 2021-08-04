package emailSendig;
/*
 * @JahirBasha
 * 04/08/2021
*/

import java.util.HashSet;
import java.util.Set;


class Main{
	public static void main(String[] args)  {
		Mail mail=new Mail();
		Set<String> Emails = get();
	
  for (String string:Emails) {
	mail.process(string);
}}
	private static Set<String> get(){
		
		Set<String> Emails = new HashSet<>();
		Emails.add("mail1");
		Emails.add("mail2");
		Emails.add("mail3");
		Emails.add("mail4");
		Emails.add("mail5");
		return Emails;
		
	}
}