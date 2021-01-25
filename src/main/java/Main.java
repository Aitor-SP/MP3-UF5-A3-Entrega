import Model.Channel;
import Model.Item;
import Model.Rss;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

//        7 crides a stream combinant elements de cerca i transformació (filter, max, distinct, map, min, count, sorted, etc.)
//        Analitzador sintàctic DOM, SAX o JAXB si treballeu amb XML o ús de llibreries per analitzar JSON o CSV
//        1 List de magatzem de dades a tractar
//        Un menú principal per fer les peticions necessàries

public class Main {

    public static final String PATH = "http://mktfan.com/rss.php?status=published";

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
            URL url = null;
            int option;

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

                do {
                    System.out.println("1. Menú Productos");
                    System.out.println("2. Menú Pedidos");
                    System.out.println("3. Menú Pedidos");
                    System.out.println("4. Menú Pedidos");
                    System.out.println("5. Menú Pedidos");
                    System.out.println("6. Menú Pedidos");
                    System.out.println("7. Menú Pedidos");
                    System.out.println("8. Salir");
                    System.out.print("Introduzca la opción: ");
                    option = input.nextInt();
                    switch (option){
                        case 1:

                            break;
                        case 2:

                            break;
                        case 3:

                            break;
                        case 4:

                            break;
                        case 5:

                            break;
                        case 6:

                            break;
                        case 7:

                            break;
                        case 8:
                            System.out.println("Saliendo.");
                            break;
                        default:
                            System.out.println("Elige una opción valida.");
                    }

                }while (option!=8);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
    }
}
