// -----------------------------------------------------------------
// Homework 1, Problem 3
// -----------------------------------------------------------------

// TODO 1/1: Write the function makeGreeter that takes a string
//           and produces a function, which then outputs a
//           greeting to any supplied name. Ok, that was a bit
//           confusing, so here's an example...
//
//           val myGreeter = makeGreeter("Howdy")
//           println(myGreeter("World"))
//
//           which should output "Howdy World" to the screen.
//
//           Once you think you have it, try using it for a couple
//           greetings and names in your main, similar to the
//           example above.
//
//           Hint: remember that "referencing" a function as a
//                 value is slightly different from calling it;
//                 the latter is just functionName(argument),
//                 whereas the former involves using the ::'s,
//                 such as ::functionName.
//

fun makeGreeter(greeting: String): (String)->String{    //fun. returning a nested fun. which has one argument provided by parent fun, one by child fun.
    fun combineGreeter(name: String): String{
        return greeting + " " + name
    }
    return ::combineGreeter
}

fun main(){     //tests and formats functions
    fun testGreeting(k: String, k2: String, expectedResult: String): Unit{      // tests and compares makeGreeter to exp. value
        println("tried $k and $k2 got ${ makeGreeter(k)(k2)}, expected $expectedResult")
    }

    testGreeting("Howdy","World", "Howdy World")
    testGreeting("Wassup", "Michael", "Wassup Michael")
    testGreeting("How are you today", "the person I am talking to", "How are you today the person I am talking to")
    //val myGreeter = makeGreeter("Howdy")
    //println(myGreeter("World"))
}

main()