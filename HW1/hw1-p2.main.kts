// -----------------------------------------------------------------
// Homework 1, Problem 2
// -----------------------------------------------------------------

// For any word of at least one character that starts with a
// letter, let's say that its "bingo word" is the uppercase
// version of the first letter, followed by a space, and then
// followed by the number of characters in the word. For example,
// the bingo word of "bingo" is "B 5" and the bingo word of "Win"
// is "W 3".

// TODO 1/1: Write the function bingoWord that takes a string as
//           an argument and returns its bingo word. You may
//           assume that the argument is a valid word as described
//           above. Now try it out a couple times by outputting a
//           word and its corresponding result in your main.
//
//           Reminder: given a string s, s.uppercase() converts it
//                     to caps and s.first() gets the first letter.
//

fun bingoWord(word: String): String{        //finds first letter, upperCases it, and finds str.length, combines two into string
    return word.first().uppercase() + " " + word.length
}

fun main() { //tests and formats above fun.
    //outputs inputs/outputs/expectations for bingoWord
    fun testBingoWord(k: String, expectedResult: String) {      //tests bingoWord and compares output to exp. output
        println("tried $k, got ${ bingoWord(k) }, expected $expectedResult")
    }

    println("== bingoWord ==")
    testBingoWord("Bingo", "B 5")
    testBingoWord("win", "W 3")
    testBingoWord("Benjamin", "B 8")
    testBingoWord("z", "Z 1")
    println()
}

main()
