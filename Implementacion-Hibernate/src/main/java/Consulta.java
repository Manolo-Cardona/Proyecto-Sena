import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.ejemplo.entidades.Usuario;

public class Consulta {
  public static void main(String[] args) {

    SessionFactory factory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(Usuario.class)
      .buildSessionFactory();

    Session session = factory.getCurrentSession();

    try {
      session.beginTransaction();

      // consulta de un usuario cuya pk tiene el valor de 1

      System.out.println("Consulta de todos los usuarios");

      List<Usuario> usuarios = session.createQuery("from Usuario", Usuario.class).list();

      for (Usuario usuario : usuarios) {
        System.out.println(usuario);
      }

      session.getTransaction().commit();

      System.out.println("Proceso finalizado");

    } finally {
      factory.close();
    }

  }

}

