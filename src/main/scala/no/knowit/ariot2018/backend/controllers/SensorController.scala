package no.knowit.ariot2018.backend.controllers

import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.time.{ZoneId, ZonedDateTime}

import no.knowit.ariot2018.backend._
import no.knowit.ariot2018.backend.database.SensorDatabase
import org.scalatra.{NoContent, Ok, ScalatraServlet}
import org.slf4j.LoggerFactory
// JSON-related libraries
import org.json4s.{DefaultFormats, Formats}

// JSON handling support from Scalatra
import org.scalatra.json._


class SensorController(sensorDatabase: SensorDatabase)(implicit val ZONEID: ZoneId) extends ScalatraServlet with JacksonJsonSupport {

  protected implicit val jsonFormats: Formats = DefaultFormats

  val logger =  LoggerFactory.getLogger(getClass)
  before() {
    logger.info(s"${request.getMethod} recieved")
    contentType = formats("json")
  }

  error {
    case e => logger.error("ERROR!", e)
  }


  get("/:sinceDays") {
    Ok(SensorResults(sensorDatabase.getStatsSince(ZonedDateTime.now(ZONEID).minusDays(params("sinceDays").toInt)).groupBy(_.sensor_id).map { case (sensor, value) => {
      SensorResultSensor(sensor, value.groupBy(_.datetime.truncatedTo(ChronoUnit.MINUTES)).toList.sortBy(_._1.toEpochSecond).map { case (datetimeHour, data) =>
        SensorResultSensorMinute(datetimeHour.toInstant.atZone(ZONEID).toLocalDateTime.toString, data.map(sd => sd.value).sum / data.length)
      })
    }
    }.toList))
  }

  post("/insertValues") {
    logger.info(s"Body=${request.body}")
    sensorDatabase.insertRecords(parsedBody.extract[MultipleSensorInserts])
    NoContent()
  }

  delete("/:id") {
    sensorDatabase.delete(params("id"))
  }
}
