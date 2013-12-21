package edu.fcu.selab.websearch;
import java.io.IOException;

import org.htmlparser.beans.StringBean;

public class HTMLParser {

	/**
	 * @param args
	 */
	public static String extractString(String URL) {
		StringBean sb = new StringBean();
		sb.setLinks(false);// 設置結果中去點鏈接
		sb.setURL(URL);// 設置你所需要濾掉網頁標籤的頁面url
		String content = sb.getStrings();
//		String[] lines = content.split("\r\n");
//		String result = "";
//		for(int i=0; i< lines.length; i++){
//			if(lines[i].length() > 60){
//				result = result + " " + lines[i];
//				//System.out.println(lines[i]);// 打印結果
//			}			
//		}
		//String[] result = temp.split("##");
		return content;
	}

	public static void main(String[] args) throws IOException {
		StringBean sb = new StringBean();
		sb.setLinks(false);// 設置結果中去點鏈接
		sb.setURL("http://www.data2impact.com/case_ex_crm_analysis.pdf");// 設置你所需要濾掉網頁標籤的頁面url
		String content = sb.getStrings();
		String[] lines = content.split("\r\n");
		String temp = "";
		for(int i=0; i< lines.length; i++){
			if(lines[i].length() > 60){
				temp = temp + "##" + lines[i];
				System.out.println(lines[i]);// 打印結果
			}			
		}
		//System.out.println(sb.getStrings());// 打印結果
	}

}
