package com.live.magento.utilities;

public class SecondUrlFormatter {
	
	public static String formatUrl(String url) throws Exception{
		String processedUrl = null;
		String urlAddr = url.toLowerCase();
		if( urlAddr.startsWith("http://") && urlAddr.endsWith(".com")){
			processedUrl = urlAddr;
			return processedUrl;
			}
		
		else if( urlAddr.startsWith("http://") && !urlAddr.endsWith(".com")){
			processedUrl = urlAddr + ".com";
			return processedUrl;
			}
		
		else if( urlAddr.startsWith("www.") && urlAddr.endsWith(".com")){
			processedUrl = "http://" + urlAddr;
			return processedUrl;
			}
		
		else if( urlAddr.startsWith("www.") && !urlAddr.endsWith(".com")){
			processedUrl = "http://" + urlAddr + ".com";
			return processedUrl;
			}
		
		else if(!urlAddr.startsWith("http://") && !urlAddr.startsWith("www.") && urlAddr.endsWith(".com")){
			processedUrl = "http://www." + urlAddr;
			return processedUrl;
			}
		
		else if(!urlAddr.startsWith("http://") && !urlAddr.startsWith("www.") && !urlAddr.endsWith(".com")){
			processedUrl = "http://www." + urlAddr + ".com";
			return processedUrl;
			}
		
		else{
			throw new Exception("There is a problem with the url address");
		}
				
	}
}


