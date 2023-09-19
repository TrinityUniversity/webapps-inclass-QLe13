package controllers

import javax.inject._

import shared.SharedMessages
import play.api.mvc._

@Singleton
class Application @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action {
    Ok(views.html.index(SharedMessages.itWorks))
  }
  def testing = Action {
    Ok(views.html.testing(SharedMessages.itWorks))
  }
  def tabular = Action {
    val stats = scala.collection.immutable.List("team1", "team2", "team3")
    Ok(views.html.testing(stats))
  }
}
