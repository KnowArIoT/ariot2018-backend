package no.knowit.ariot2018

import java.time.ZonedDateTime

package object backend {

  case class User(
    id: Option[Int],
    auth0_id: String,
    name: String,
    heightInCm: Int,
    weightInKg: Int,
    sex: String
  )
  case class Bed(
    id: Option[Int],
    longitude: Float,
    latitude: Float
   )
  case class Sensor(
    id: Option[Int],
    common_name: String
  )
  case class Routine(
    id: Option[Int],
    scheduled_start: ZonedDateTime,
    creator_id: Int,
    operations: List[Operation] = Nil
  )
  case class Operation(
    id: Option[Int],
    actuator: Actuator,
    datetime: ZonedDateTime,
  )
  case class SensorData(
    id: Option[Int],
    sensor_id: String,
    value: Float,
    datetime: ZonedDateTime,
    user_id: Int,
    bed_id: Int
  )
  case class Actuator(
    id: Option[Int],
    common_name: String,
    bed_id: Int
  )

  case class MultipleSensorInserts(bed_id: String, data: List[SensorValue])
  case class SensorValue(id: String, value: Int)
}
