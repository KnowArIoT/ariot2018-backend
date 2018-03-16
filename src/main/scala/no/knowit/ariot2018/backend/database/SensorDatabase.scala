package no.knowit.ariot2018.backend.database

import java.time.{ZoneId, ZonedDateTime}

import no.knowit.ariot2018.backend.{MultipleSensorInserts, SensorData}
import scalikejdbc._

class SensorDatabase(implicit val ZONEID: ZoneId) {
  def getStatsSince(time: ZonedDateTime): List[SensorData] = DB readOnly { implicit session =>
    sql"SELECT * FROM zzzmartbed.sensor_data AS sd WHERE sd.datetime < $time".map(rs => SensorData(
      id = Some(rs.int("id")),
      sensor_id = rs.string("sensor_id"),
      value = rs.float("value"),
      datetime = rs.dateTime("datetime"),
      user_id = rs.int("user_id"),
      bed_id = rs.int("bed_id")
    )
    ).list().apply()
  }

  def delete(key: String): Any = ???

  def insertRecords(msi: MultipleSensorInserts): Unit = DB localTx  { implicit session =>
    val batchParams = msi.data.map(sensorValue => List(sensorValue.id, sensorValue.value, ZonedDateTime.now(ZONEID), 1, 1))
    sql"INSERT INTO zzzmartbed.sensor_data(sensor_id, value, datetime, user_id, bed_id) VALUES (?, ?, ?, ?, ?)".batch(batchParams: _*).apply()
  }

}
