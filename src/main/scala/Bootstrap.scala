import com.wordnik.swagger.sample._
import javax.servlet.ServletContext
import org.scalatra.LifeCycle

class Bootstrap extends LifeCycle {
  implicit val swagger = new PetstoreSwagger

  override def init(context: ServletContext) {
    try {
      val petServlet = new PetServlet
      context mount (petServlet, "/pet")
      context mount (new ResourcesApp, "/")
    } catch {
      case e: Throwable => e.printStackTrace()
    }
  }

}
