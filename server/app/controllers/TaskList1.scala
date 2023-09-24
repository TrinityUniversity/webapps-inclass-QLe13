package controllers

import javax.inject._

import shared.SharedMessages
import play.api.mvc._
import java.lang.ProcessBuilder.Redirect


@Singleton
class TaskList1 @Inject()(cc: ControllerComponents) extends AbstractController(cc){
    def login = Action {
        Ok(views.html.login1())
    }
    def validateLoginGet(username: String, password: String) = Action {
        Ok(s"Username is $username and password is $password")
    }
    def validateLoginPost = Action{ rq =>
        val postVals = rq.body.asFormUrlEncoded
        postVals.map{args =>
            val username = args("username").head
            val password = args("password").head
            Redirect(routes.TaskList1.taskList)

        }.getOrElse(Redirect(routes.TaskList1.login))
        
    }
    def taskList = Action {
        val teamNames = List(
                    "MilwaukeeBucks",
                    "BostonCeltics",
                    "Philadelphia76ers",
                    "ClevelandCavaliers",
                    "NYKnicks",
                    "BrooklynNets",
                    "MiamiHeat",
                    "AtlantaHawks",
                    "TorontoRaptors",
                    "ChicagoBulls",
                    "IndianaPacers",
                    "WashingtonWizards",
                    "OrlandoMagic",
                    "CharlotteHornets",
                    "DetroitPistons",
                    "DenverNuggets",
                    "MemphisGrizzlies",
                    "SacramentoKings",
                    "PhoenixSuns",
                    "GSWarriors",
                    "LAClippers",
                    "LALakers",
                    "NOrleansPelicans",
                    "MinnesotaT-wolves",
                    "OklahomaCityThunder",
                    "DallasMavericks",
                    "UtahJazz",
                    "PortlandTrailBlazers",
                    "SanAntonioSpurs",
                    "HoustonRockets"
                    )
        val stats = scala.collection.immutable.Seq(
  ("MilwaukeeBucks", 58),
  ("BostonCeltics", 57),
  ("Philadelphia76ers", 54),
  ("ClevelandCavaliers", 51),
  ("NYKnicks", 47),
  ("BrooklynNets", 45),
  ("MiamiHeat", 44),
  ("AtlantaHawks", 41),
  ("TorontoRaptors", 41),
  ("ChicagoBulls", 40),
  ("IndianaPacers", 35),
  ("WashingtonWizards", 35),
  ("OrlandoMagic", 34),
  ("CharlotteHornets", 27),
  ("DetroitPistons", 17),
  ("DenverNuggets", 53),
  ("MemphisGrizzlies", 51),
  ("SacramentoKings", 48),
  ("PhoenixSuns", 45),
  ("GSWarriors", 44),
  ("LAClippers", 44),
  ("LALakers", 43),
  ("NOrleansPelicans", 42),
  ("MinnesotaT-wolves", 42),
  ("OklahomaCityThunder", 40),
  ("DallasMavericks", 38),
  ("UtahJazz", 37),
  ("PortlandTrailBlazers", 33),
  ("SanAntonioSpurs", 22),
  ("HoustonRockets", 22)
)
        Ok(views.html.taskList1(stats))
    }

}
