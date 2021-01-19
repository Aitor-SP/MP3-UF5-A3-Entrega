package Model;

import lombok.Data;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Item {
    private String title, category, sub, clicks, karma;
    private String pubDate, negatives;
    private String url;
}
