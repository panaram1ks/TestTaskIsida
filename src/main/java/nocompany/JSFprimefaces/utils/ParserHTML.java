package nocompany.JSFprimefaces.utils;

import nocompany.JSFprimefaces.entity.TagA;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ParserHTML {

    public static List<TagA> parse(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        return  doc.select("a").stream()
                .filter(element -> !element.absUrl("href").equals(""))
                .map(el -> new TagA(el.absUrl("href"), el.ownText()))
                .collect(Collectors.toList());
    }
}
