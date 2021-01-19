import Model.Rss;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;
import java.net.MalformedURLException;
import java.net.URL;

//        7 crides a stream combinant elements de cerca i transformació (filter, max, distinct, map, min, count, sorted, etc.)
//        Analitzador sintàctic DOM, SAX o JAXB si treballeu amb XML o ús de llibreries per analitzar JSON o CSV
//        1 List de magatzem de dades a tractar
//        Un menú principal per fer les peticions necessàries

public class Main {

    public static final String PATH = "https://www.meneame.net/rss";

    public static void main(String[] args) {

            URL url = null;

            try {
                url = new URL(PATH);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            try {
                JAXBContext contextObj = JAXBContext.newInstance(Rss.class);
                // Unmarshaller pasar XML a JAVA
                Unmarshaller unmarshallerObj = contextObj.createUnmarshaller();

                Rss rss = (Rss) unmarshallerObj.unmarshal(url);

                rss.getChannel().getLlistaItems().forEach(System.out::println);

            } catch (JAXBException e) {
                e.printStackTrace();
            }
    }
}
