package edu.fcu.selab.websearch;
import java.io.IOException;

import org.htmlparser.beans.StringBean;

public class HTMLParser {

	/**
	 * @param args
	 */
	public static String extractString(String URL) {
		StringBean sb = new StringBean();
		sb.setLinks(false);// �]�m���G���h�I�챵
		sb.setURL(URL);// �]�m�A�һݭn�o���������Ҫ�����url
		String content = sb.getStrings();
//		String[] lines = content.split("\r\n");
//		String result = "";
//		for(int i=0; i< lines.length; i++){
//			if(lines[i].length() > 60){
//				result = result + " " + lines[i];
//				//System.out.println(lines[i]);// ���L���G
//			}			
//		}
		//String[] result = temp.split("##");
		return content;
	}

	public static void main(String[] args) throws IOException {
		StringBean sb = new StringBean();
		sb.setLinks(false);// �]�m���G���h�I�챵
		sb.setURL("http://www.data2impact.com/case_ex_crm_analysis.pdf");// �]�m�A�һݭn�o���������Ҫ�����url
		String content = sb.getStrings();
		String[] lines = content.split("\r\n");
		String temp = "";
		for(int i=0; i< lines.length; i++){
			if(lines[i].length() > 60){
				temp = temp + "##" + lines[i];
				System.out.println(lines[i]);// ���L���G
			}			
		}
		//System.out.println(sb.getStrings());// ���L���G
	}

}
