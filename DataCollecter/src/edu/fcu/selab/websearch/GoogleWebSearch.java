package edu.fcu.selab.websearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GoogleWebSearch {

	public static void main(String[] args) throws IOException {
		// The request also includes the userip parameter which provides the end
		// user's IP address. Doing so will help distinguish this legitimate
		// server-side traffic from traffic which doesn't come from an end-user.

		int numOfSite = 0;
		String keyword;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please input keyword: ");
		System.out.printf("Start collecting! Please wait...[%s]", keyword = scanner.nextLine());
		System.out.println();
		URL url;
		for (int i = 0; i < 8; i++) {
			int startFrom = i * 8;
			url = new URL("https://ajax.googleapis.com/ajax/services/search/web?v=1.0" // version
					+ "&q=" + keyword.replaceAll(" ", "%20") // keyword
					+ "&rsz=8" // # of result per page, MAX=8
					+ "&hf=zh" // host language
					+ "&start=" + startFrom); // start from result #

			URLConnection connection = url.openConnection();

			System.out.println("------------------------------------------------------------------------------------------------------------");
			System.out.println(url);
			System.out.println("------------------------------------------------------------------------------------------------------------");
			String line;
			StringBuilder builder = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF8"));
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}

			String response = builder.toString();

			JSONObject json = new JSONObject();
			json.put("CRM", response);
			// System.out.println(json);
			// now have some fun with the results...
			JSONArray ja = json.getJSONObject("CRM").getJSONObject("responseData").getJSONArray("results");

			for (int j = 0; j < ja.size(); j++) {
				JSONObject o = ja.getJSONObject(j);
				String URL = o.getString("url");
				System.out.println("[" + URL + "]");
				if (!URL.contains(".pdf")) {
					System.out.println(HTMLParser.extractString(URL));
					System.out.println();
				}
				numOfSite++;
			}
			System.out.println("Total sites: " + numOfSite);
		}
	}
}
