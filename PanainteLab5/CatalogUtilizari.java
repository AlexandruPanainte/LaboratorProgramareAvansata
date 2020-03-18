/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanainteLab5;
import java.awt.Desktop;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
/**
 *
 * @author Panainte
 */
public class CatalogUtilizari {
    public  void save(Catalog catalog)throws IOException 
    {
        try (FileOutputStream fos = new FileOutputStream(catalog.getPath())) {
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(catalog);
        }
    }
    public Catalog load(String path) throws InvalidCatalogException, FileNotFoundException, IOException, ClassNotFoundException
    {
        try (FileInputStream fis = new FileInputStream(path)) {
            ObjectInputStream in = new ObjectInputStream(fis);
            Catalog c=(Catalog)in.readObject();
            return c;
        }
    }
    public void view(Document doc) throws IOException, URISyntaxException 
    {
        Desktop desktop = Desktop.getDesktop();
        File f=new File(doc.getLocation());
        if(doc.getLocation().contains("http"))
        {
            URI uri=new URI(doc.getLocation());
            desktop.browse(uri);
        }
        else desktop.open(f);
     }
}
