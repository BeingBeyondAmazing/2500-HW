// -----------------------------------------------------------------
// Homework 2, Problem 3
// -----------------------------------------------------------------

// We are making nametags for a (magical) student event, and want
// to make sure they have enough space for all the letters in each
// name. We are also formatting the nametags so that they have a
// consistent format: Last, First Middle - this way the teachers
// can accurately praise/critique their students.
//
// TODO 1/1: Given the data types and examples below, design the
//           function numCharsNeeded that takes a magical pair and
//           returns the number of characters that would be
//           necessary to represent the longer student's formatted
//           name.
//
//           For instance, if Hermione and Ron are paired, her
//           formatted name is "Granger, Hermione Jean" (22
//           characters) and his is "Weasley, Ron Bilius" (19
//           characters), and so the function should return 22.
//
//           Note the nested data types, and so duplicated work -
//           let type-driven development lead you to an effective
//           decomposition of well-designed functions :)
//
import khoury.testSame

fun numCharsNeeded(pair: MagicPair): Int {
    val chars1 = formatName(pair.p1).length
    val chars2 = formatName(pair.p2).length
    when (chars1 > chars2) {
        true -> return chars1
        else -> return chars2
    }
}

fun formatName(p: Name): String {
    return "${p.last}, ${p.first} ${p.middle}"
}

// represents a person's first/middle/last names
data class Name(val first: String, val middle: String, val last: String)

val HJP = Name("Harry", "James", "Potter")
val HJG = Name("Hermione", "Jean", "Granger")
val RBW = Name("Ron", "Bilius", "Weasley")

// represents a pairing of two names
data class MagicPair(val p1: Name, val p2: Name)

val MAGIC_HARRY_RON = MagicPair(HJP, RBW)
val MAGIC_HARRY_HERMIONE = MagicPair(HJP, HJG)
val MAGIC_HERMIONE_RON = MagicPair(HJG, RBW)

testSame(numCharsNeeded(MAGIC_HARRY_RON), 19, "num chars harry and ron")
testSame(numCharsNeeded(MAGIC_HARRY_HERMIONE), 22, "num chars harry and hermione")
testSame(numCharsNeeded(MAGIC_HERMIONE_RON), 22, "num chars hermione and ron")
