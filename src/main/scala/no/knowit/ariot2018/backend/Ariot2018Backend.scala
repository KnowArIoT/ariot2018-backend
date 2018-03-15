package no.knowit.ariot2018.backend

import org.scalatra._

class Ariot2018Backend extends ScalatraServlet {

  get("/") {
    Ok("lala")
  }

}
