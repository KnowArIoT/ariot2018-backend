package no.knowit.ariot2018.backend.controllers

import java.time.{ZoneId, ZonedDateTime}

import no.knowit.ariot2018.backend.MultipleSensorInserts
import no.knowit.ariot2018.backend.database.SensorDatabase
import org.scalatra.{Ok, ScalatraServlet}
// JSON-related libraries
import org.json4s.{DefaultFormats, Formats}

// JSON handling support from Scalatra
import org.scalatra.json._


class SensorController(sensorDatabase: SensorDatabase)(implicit val ZONEID: ZoneId) extends ScalatraServlet with JacksonJsonSupport {

  protected implicit val jsonFormats: Formats = DefaultFormats

  before() {
    contentType = formats("json")
  }

  get("/:sinceDays") {
    Ok(sensorDatabase.getStatsSince(ZonedDateTime.now(ZONEID).minusDays(params("sinceDays").toInt)))
  }

  post("/insertValues") {
    sensorDatabase.insertRecords(parsedBody.extract[MultipleSensorInserts])
    Ok()
  }

  delete("/:id") {
    sensorDatabase.delete(params("id"))
  }
}
