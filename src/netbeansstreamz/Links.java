package netbeansstreamz;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.*;
import java.util.*;
import java.util.function.Predicate;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Links {
    private String url;
    private Map<String, Collection<String>> finalLinks = new HashMap<>();    
    
    /**
     * Constructor for Links class, sets URL to the value passed,
     * and calls setLinksToDive.
     * @param url a String of the URL to be accessed and have links scraped from.
     */
    public Links(String url){
        this.url = url;
        setLinksToDive();
    }
    
    /**
     * Tries to connect to the link set in data-field,
     * Then finds the posts on Reddit for each Game Thread, and calls diveLink on each Game Thread link.
     */
    private void setLinksToDive(){
        try {
            Document doc = Jsoup.connect(this.url).get();
            
            // Need better way of getting links to dive, otherwise will have to manually update reddit CSS selectors
            // Elements h2Only = doc.select("h2.s56cc5r-0");
            // Most recent css selector: .s1okktje-0
            Elements h2Only = doc.select("h2");

            h2Only.forEach((m) -> {
                String text = m.text();
                if (text.matches("(.*)(\\s)(?i)v(\\s)(.*)") || text.matches("(.*)(\\s)(?i)vs(\\s)(.*)") || text.matches("(.*)(\\s)(?i)vs.(\\s)(.*)") || text.matches("(.*)(\\s)(?i)v.(\\s)(.*)") || text.matches("(.*)(\\s)(?i)at(\\s)(.*)") || text.matches("(.*)(\\s)(?i)@(\\s)(.*)")) {
                    text = text.replaceAll("(?i)game thread:", "").replaceAll("(?i)archive thread:", "").replaceAll("(?i)event thread thread:", "").replaceAll("(\\[)([A-Za-z0-9:\\s])*(\\])", "").replaceAll("(\\()([A-Za-z0-9:\\s])*(\\))", "").trim();
                    finalLinks.put(text, diveLink(m.parent().attr("abs:href")));
                }
            });

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Takes a String representing a URL of a Game Thread.
     * It tries to connect to the URL, and scrapes for any live-stream links and adds them to a LinkedHashSet.
     * 
     * @param link the URL that should be connected to and scraped for streams.
     * @return eachLink a Collection of strings storing each live-stream link for the associated Game Thread.
     */
    public Collection<String> diveLink(String link){
        Collection<String> eachLink = new LinkedHashSet<>();
        try {
            Document doc = Jsoup.connect(link).get();

            //Elements streamsOnly = doc.select("a[href].s14dydj4-27");
            Elements allLinks = doc.select("a[href]");
            
            allLinks.stream().filter((t) -> (t.parent().parent().parent().parent().parent().className().contains("Comment")));

            //allLinks.stream().filter((Element t) -> t.parent().parent().parent().parent().parent().className().contains("Comment"));
//            for(Element e : allLinks){
//                String httpHref = e.attr("abs:href");
//                if(!(httpHref.contains("https://www.reddit.com") || httpHref.contains("https://discord") || httpHref.contains("https://time.is") || httpHref.matches("(((https)||(http))://image.prntscr.com(.*))") || httpHref.matches("((https)||(http)://i.imgur.com(.*))") || httpHref.matches("(http://www.timebie.com)(.*)") || httpHref.matches("((https://)||(http://))(.*)reddit(.*)(.com)(.*)"))){
//                    eachLink.add(httpHref);
//                }
//            }
            allLinks.stream().map((h) -> h.attr("abs:href")).filter((httpHref) -> (!(httpHref.contains("https://www.reddit.com") || httpHref.contains("https://discord") || httpHref.contains("https://time.is") || httpHref.matches("(((https)||(http))://image.prntscr.com(.*))") || httpHref.matches("((https)||(http)://i.imgur.com(.*))") || httpHref.matches("(http://www.timebie.com)(.*)") || httpHref.matches("((https://)||(http://))(.*)reddit(.*)(.com)(.*)")))).forEachOrdered((httpHref) -> {
                eachLink.add(httpHref);
            });
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return eachLink;
    }
    
    /**
     * 
     * @return finalLinks a Map -- stream names, and a Collection of Strings that are URLs to streams.
     */
    public Map<String, Collection<String>> getFinalLinks(){
        return finalLinks;
    }
}
    
    
    
//                if((text.matches(".*\\d+.*") || text.contains("Game Thread")) && !text.contains("PS4") && !text.contains("NHL TV") && !text.contains("PLEASE")){
//                    String httpHref = m.parent().attr("abs:href");
//                    //System.out.println("Link: " + httpHref);
//                    text = text.replaceAll("(\\[)([A-Za-z0-9:\\s])*(\\])", "").trim();
//                    text = text.replaceAll("(?i)game thread:", "").trim();
//                    text = text.replaceAll("(?i)archive thread:", "").trim();
//                    text = text.replaceAll("(?i)event thread thread:", "").trim();
//                    if(httpHref.length() > 0){
//                        finalLinks.put(text, diveLink(httpHref));
//                    }
//                }

