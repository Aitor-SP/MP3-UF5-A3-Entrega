import Model.Channel;
import Model.Item;
import Model.Rss;
import jdk.jfr.Event;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//        7 crides a stream combinant elements de cerca i transformació (filter, max, distinct, map, min, count, sorted, etc.)
//        Analitzador sintàctic DOM, SAX o JAXB si treballeu amb XML o ús de llibreries per analitzar JSON o CSV
//        1 List de magatzem de dades a tractar
//        Un menú principal per fer les peticions necessàries

public class Main {

    public static final String PATH = "http://mktfan.com/rss.php?status=published";

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Channel channel = new Channel();
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

                do {
                    System.out.println("1. Filter - Mostrar las noticias de categoría: DIGITAL.");
                    System.out.println("2. Max - Mostrar la noticia con más votos.");
                    System.out.println("3. Distinct - Mostrar los autores de todas las noticias.");
                    System.out.println("4. Map - Mostrar la fecha de publicación de todas las noticias.");
                    System.out.println("5. Min - Mostrar la noticia con menos votos.");
                    System.out.println("6. Count - Mostrar el número de noticias publicadas por el usuario: cinacio06.");
                    System.out.println("7. Sorted - Mostrar las noticias por orden alfabético.");
                    System.out.println("8. Mostrar los datos recibidos a través del XML.");
                    System.out.println("9. Salir");
                    System.out.print("Introduzca la opción: ");
                    option = input.nextInt();
                    switch (option){
                        case 1:
                            rss.getChannel().getLlistaItems().stream().filter(item -> item.getCategory().equals("DIGITAL")).forEach(System.out::println);
                            break;
                        case 2:
                            rss.getChannel().getLlistaItems().stream().max(Comparator.comparing(Item::getVotes)).stream().forEach(System.out::println);
                            break;
                        case 3:
                            rss.getChannel().getLlistaItems().stream().map(Item::getAuthor).distinct().forEach(System.out::println);
                            break;
                        case 4:
                            rss.getChannel().getLlistaItems().stream().map(Item::getPubDate).forEach(System.out::println);
                            break;
                        case 5:
                            rss.getChannel().getLlistaItems().stream().min(Comparator.comparing(Item::getVotes)).stream().forEach(System.out::println);
                            break;
                        case 6:
                            System.out.println("Número de noticias publicadas por cinacio06 -> "+rss.getChannel().getLlistaItems().stream().filter(item -> item.getAuthor().equals("cinacio06")).count());
                            break;
                        case 7:
                            // Intentaba ordenar por fecha de publicación pero como comienza con el día de la semana coge el Friday por orden alfabético y entonces no sale como quiero.
                            rss.getChannel().getLlistaItems().stream().sorted(Comparator.comparing(item -> item.getTitle())).forEach(System.out::println);
                            break;
                        case 8:
                            rss.getChannel().getLlistaItems().forEach(System.out::println);
                            break;
                        case 9:
                            System.out.println("Saliendo.");
                            break;
                        default:
                            System.out.println("Elige una opción valida.");
                    }
                }while (option!=9);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
    }
}
