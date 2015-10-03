package com.live.magento.utilities;

public class UrlFormatter {
	
	public static String formatUrl(String url){
		if(url.endsWith(".com")&& url.startsWith("http://")){
			return url;
			}
		else if (!url.endsWith(".com") && url.startsWith("http://")){
			return (url + ".com");
		}	
		else if(url.endsWith(".com")&& !url.startsWith("http://")){
			return ("http://" +url);
			}
			
		else if(!url.endsWith(".com")&& !url.startsWith("http://")){
				return ("http://" +url + ".com");
			}
		else{
			return ("Url is not recognised");
		}
	
		
		}
		}
		
