package addendum

import spark.Spark.get

fun main(args: Array<String>) {



    // Multiline strings and string interpolation
    get("/multiline-interpolation-example") { req, res ->
        val name = "Alice"
        val email = "alice@alice.kt"
        """
            <h1>Hello $name</h1>
            <p>Your email is $email</p>
        """
    }



    // Default arguments
    fun serverError(code: Int = 500, message: String = "Internal server error"): String {
        return """
            <h1 style="font-family:monospace">$message (Error $code)</h1>
            <p style="font-family:monospace">We're sorry, but our server messed up. Please back and try again.</p>
        """
    }

    get("/internal-server-error") { req, res ->
        serverError();
    }

    get("/not-implemented") { req, res ->
        serverError(code = 501, message = "Not implemented");
    }



    // When expression
    get("/when-example") { req, res ->
        when (req.queryParams("lang")) {
            "EN" -> "Hello!"
            "FR" -> "Salut!"
            "IT" -> "Ciao!"
            else -> "Sorry, I can't greet you in ${req.queryParams("lang")} yet"
        }
    }



    // Companion object
    get("static-controller-example", CompanionController.controllerOne)
    get("static-controller-two-example", CompanionController.controllerTwo)



}



