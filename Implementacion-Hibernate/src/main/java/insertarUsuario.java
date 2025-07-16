import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.ejemplo.entidades.Usuario;

public class insertarUsuario {

  public static void main(String[] args) {

    SessionFactory factory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(Usuario.class)
      .buildSessionFactory();

    Session session = factory.getCurrentSession();

    try {

      session.beginTransaction();

      Usuario user = new Usuario("Juan", "David Mendoza", 1955411405, "juan000david@gmail.com");

      session.persist(user);

      session.getTransaction().commit();

      System.out.println("El registro fue almacenado!");


    } finally {
      factory.close();
    }
  }

}

