package newjuso;

import java.net.*;
import java.io.*;

public class URLConnectionTest {
    public static void main(String[] args) throws Exception {
        URL oracle = new URL("http://www.juso.go.kr/support/AddressMainSearch.do?searchType=TOTAL&searchKeyword=%EC%A3%BD%EB%A6%BC%EB%8F%99+150");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    yc.getInputStream()));
        StringBuffer sb = new StringBuffer();
        String inputLine;
        while ((inputLine = in.readLine()) != null) 
            sb.append(inputLine + "\n");
        in.close();
        
        String html = sb.toString();
        int startIndex = html.indexOf("tab1c1");
        int endIndex = html.indexOf("mapView", startIndex);
		System.out.println(html.substring(startIndex, endIndex));
    }
}