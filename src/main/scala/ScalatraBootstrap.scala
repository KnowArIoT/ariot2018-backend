import java.time.ZoneId
import javax.servlet.ServletContext

import no.knowit.ariot2018.backend.controllers.SensorController
import no.knowit.ariot2018.backend.database.SensorDatabase
import org.json4s.{DefaultFormats, Formats}
import org.scalatra._
import scalikejdbc.AutoSession

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {

    implicit val ZONEID: ZoneId = ZoneId.of("Europe/Oslo")

    implicit val formats: Formats = DefaultFormats
    implicit val session: AutoSession.type = AutoSession
    scalikejdbc.config.DBs.setupAll()

    context.mount(new SensorController(new SensorDatabase), "/sensorData/*")
  }
}
