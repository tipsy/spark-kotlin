package addendum

import spark.Request
import spark.Response

class CompanionController {
    companion object  {
        val controllerOne = { req: Request, res: Response ->
            "Hello controllerOne!"
        }
        val controllerTwo = { req: Request, res: Response ->
            "Hello controllerTwo!"
        }
    }
}