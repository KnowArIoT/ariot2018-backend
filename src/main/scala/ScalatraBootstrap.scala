import javax.servlet.ServletContext

import no.knowit.ariot2018.backend.Ariot2018Backend
import org.scalatra._

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(new Ariot2018Backend, "/*")
  }
}
