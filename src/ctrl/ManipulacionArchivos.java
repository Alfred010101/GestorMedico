package ctrl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import poo.Alumnos;
import poo.Datos;
import poo.Personal;

/**
 *
 * @author alfredo
 */
public class ManipulacionArchivos
{
    private static final String ruta = "src/BD/";
    //private static Path path = Paths.get(ruta);
    //private static boolean existe = Files.exists(path);
    
    public static void guardar(JFrame jf, Object obj, String s)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("../Datos/" + s);
            ObjectOutputStream arch = new ObjectOutputStream(fos);
            arch.writeObject(obj);
            arch.close();
        } catch (FileNotFoundException ex)
        {
            Mensajes.error(jf, "No se encontro el archivo");
        } catch(Exception ex)
        {
            Mensajes.error(jf, "Error..." + ex.toString());
        }
    }
    
    public static void guardar(JFrame jf, Object[] obj, String s)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("../Datos/" + s);
            ObjectOutputStream arch = new ObjectOutputStream(fos);
            arch.writeObject(obj);
            arch.close();
        } catch (FileNotFoundException ex)
        {
           // Mensajes.error(jf,"No se encontro el archivo");
        } catch(Exception ex)
        {
           // Mensajes.error(jf,"Error..." + ex.toString());
        }
    }
    
    public static Object carga(JFrame jf, String s)
    {
        Object obj = null;
        try
        {
            FileInputStream fis = new FileInputStream("../Datos/" + s);
            ObjectInputStream arch = new ObjectInputStream(fis);
            obj = arch.readObject();
            arch.close();
        } catch (FileNotFoundException ex)
        {
            //Mensajes.error(jf, "No se econtro el archivo");
        } catch(Exception ex)
        {
            //Mensajes.error(jf,"Error..." + ex.toString());
        }
        return obj;
    }
    
//    public static Object[] cargaArch(JPanel pn, String s)
//    {
//        Object[] obj = null;
//        try
//        {
//            FileInputStream fis = new FileInputStream("src/BD/" + s);
//            ObjectInputStream arch = new ObjectInputStream(fis);
//            obj = (Object[]) arch.readObject();
//            arch.close();
//        } catch (FileNotFoundException ex)
//        {
//            JOptionPane.showMessageDialog(pn,"No se econtro el archivo", "Error de conexion", JOptionPane.ERROR_MESSAGE);
//        } catch(Exception ex)
//        {
//            JOptionPane.showMessageDialog(pn,"Error...", "Error..." + ex.toString(), JOptionPane.ERROR_MESSAGE);
//        }
//        return obj;
//    }
    
    public static Object[] cargaArch(JPanel pn, String s, boolean tipoError)
    {
        Object[] obj = null;
        try
        {
            FileInputStream fis = new FileInputStream(ruta + s);
            ObjectInputStream arch = new ObjectInputStream(fis);
            obj = (Object[])arch.readObject();
            arch.close();
        } catch (FileNotFoundException ex)
        {
            if (tipoError)
            {
                JOptionPane.showMessageDialog(pn, "Si es la primera vez que realiza un registro\neste mensaje es normal.\nSi no es a si consulte al administrador ", "No se econtro el archivo", JOptionPane.WARNING_MESSAGE);
            }else
            {
                JOptionPane.showMessageDialog(pn, "No se han econtrado registros", "No se econtro el archivo", JOptionPane.WARNING_MESSAGE);
            }
        } catch(Exception ex)
        {
            JOptionPane.showMessageDialog(pn, "Error..." + ex.toString(), "Error de conexion...", JOptionPane.ERROR_MESSAGE);
            System.out.println( ex.toString());
        }
        return obj;
    }
    
    public static boolean guardarReg(JPanel pn, Datos obj, String s)
    {
        //Object[] obj = null;
        Datos[] array = (Datos[]) ManipulacionArchivos.cargaArch(pn, "personal.dat", true);
       /* if(obj instanceof Personal)
        {
            array = (Personal[]) ManipulacionArchivos.cargaArch(pn, "personal.dat");
            if (array == null)
            {
                array = new Personal[1];
            }else
            {
                Datos nvoArray[] = new Personal[array.length + 1];
                System.arraycopy(array, 0, nvoArray, 0, array.length);
                array = nvoArray;
            }
            array[array.length - 1] = (Personal)obj;
        }else if(obj instanceof Alumnos)
        {
            array = (Alumnos[]) ManipulacionArchivos.cargaArch(pn, "personal.dat");
            if (array == null)
            {
                array = new Alumnos[1];
            }else
            {
                Datos nvoArray[] = new Alumnos[array.length + 1];
                System.arraycopy(array, 0, nvoArray, 0, array.length);
                array = nvoArray;
            }
            array[array.length - 1] = (Alumnos)obj;
        }*/
       
       
            if (array == null)
            {
                array = new Datos[1];
            }else
            {
                Datos nvoArray[] = new Datos[array.length + 1];
                System.arraycopy(array, 0, nvoArray, 0, array.length);
                array = nvoArray;
            }
            array[array.length - 1] = obj;
        try
        {
            FileOutputStream fos = new FileOutputStream(ruta + s);
            ObjectOutputStream arch = new ObjectOutputStream(fos);
            arch.writeObject(array);
            arch.close();
        } catch (FileNotFoundException ex)
        {
            JOptionPane.showMessageDialog(pn,"No se econtro el archivo", "Error de conexion", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.toString());
            return false;
        } catch(Exception ex)
        {
            JOptionPane.showMessageDialog(pn, "Error..." + ex.toString(), "Error...",JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.toString());
            return false;
        }
        return true;
    }
}
