import com.wordnik.swagger.sample._
import javax.servlet.ServletContext
import org.scalatra.LifeCycle

class ScalatraBootstrap extends LifeCycle {
  implicit val swagger = new PetstoreSwagger

  override def init(context: ServletContext) {
    try {
      context mount (new PetServlet, "/pet")
      context mount (new ResourcesApp, "/")
    } catch {
      case e: Throwable => e.printStackTrace()
    }
  }

}
