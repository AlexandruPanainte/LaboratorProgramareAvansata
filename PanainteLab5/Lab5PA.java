/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanainteLab5;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 *
 * @author Panainte
 */
public class Lab5PA {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InvalidCatalogException, FileNotFoundException, ClassNotFoundException, URISyntaxException
    {
        Catalog c = new Catalog("CatalogulMeu","catalog.ser");
        CatalogUtil cu=new CatalogUtil();
        Document d1=new Document("testnr1", "testernr1",
        "C:\\Users\\Panainte\\Documents\\NetBeansProjects\\Pa_Lab5\\test.ser");
        Document d2=new Document("java1", "Java Course 1",
        "https://docs.oracle.com/javase/7/docs/technotes/tools/windows/classpath.html");
        Document d3=new Document("testnr2", "testernr2",
        "https://docs.oracle.com/javase/tutorial/essential/io/");
        c.add(d1);
        c.add(d2);
        c.add(d3);
        cu.save(c);
        Catalog alt=cu.load("catalog.ser");
        Document testdoc=alt.findById("test2");
        cu.view(testdoc);
    }
}
