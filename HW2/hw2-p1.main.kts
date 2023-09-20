// -----------------------------------------------------------------
// Homework 2, Problem 1
// -----------------------------------------------------------------

// TODO 1/1: Design the predicate startsWithY that determines if
//           the supplied string starts with the letter "y"
//           (either upper or lowercase).
//
//           Hints:
//            - The string.startsWith(prefix) function will help
//              evaluate the prefix (even if the string is too
//              short).
//            - The string.lowercase/uppercase() functions help
//              you not worry about case.
//            - Remember that "designing" a function means to
//              document and test it!
//

fun startsWithY(str: String): Boolean {
    return str.lowercase().startsWith("y")
}

fun main() {
    fun startsWithYTester(
        str: String,
        expected: Boolean,
    ) {
        println("Tried $str got ${startsWithY(str)} expected $expected")
    }

    startsWithYTester("yellow", true)
    startsWithYTester("mellow", false)
    startsWithYTester("", false)
    startsWithYTester("Y", true)
}
main()
