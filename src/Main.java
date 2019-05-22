import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

    public static void main(String[] args) {
        String url = "https://dumskaya.net";
        System.out.println("Fetching data from URI: "  + url);

        References hlinks = new References();

        int n = 0;
        try
        {
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("div[class=menutable]");
            for (Element link : links)
            {


                        System.out.println(link.text());
                        Elements lal = link.select("a");
                System.out.println(lal.text().substring(0,6));
                System.out.println(lal.text().substring(6,14).replace(" ","")+lal.attr("href"));
                System.out.println(lal.text().substring(14,17).replace(" ",""));
                System.out.println(lal.text().substring(17,23).replace(" ",""));
                System.out.println(lal.text().substring(23,27).replace(" ",""));

                for (Element aa: lal
                     ) {

                    Elements sps = aa.select("a");
                    hlinks.list.add(new Reference(sps.text(),url+sps.attr("href")));


                }



                    
            
            }

            for (Reference r: hlinks.list)
            {

                System.out.println(r);
            }
        }
        catch(Exception exc)
        {
            System.out.println("Page loading error!!!");
        }
    }
}
