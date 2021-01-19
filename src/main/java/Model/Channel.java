package Model;

import lombok.Data;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "channel")
@XmlAccessorType(XmlAccessType.FIELD)

public class Channel {

    @XmlElement(name = "item")
    private List<Item> llistaItems;

    public List<Item> getLlistaItems() {
        return llistaItems;
    }

    public void setLlistaItems(List<Item> llistaItems) {
        this.llistaItems = llistaItems;
    }
}
