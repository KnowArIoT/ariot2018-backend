package no.knowit.ariot2018.backend

import org.scalatra.test.scalatest._

class ariot2018-backendTests extends ScalatraFunSuite {

  addServlet(classOf[ariot2018-backend], "/*")

  test("GET / on ariot2018-backend should return status 200"){
    get("/"){
      status should equal (200)
    }
  }

}
