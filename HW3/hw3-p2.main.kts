// -----------------------------------------------------------------
// Homework 3, Problem 2
// -----------------------------------------------------------------
import khoury.testSame
// TODO 1/4: Design the data type FlashCard to represent a single
//           flash card. You should be able to represent the text
//           prompt on the front of the card as well as the text
//           answer on the back. Include at least 3 example cards
//           (which will come in handy later for tests!).
//

data class FlashCard(val front: String, val back: String)
val name = FlashCard("What is my name?", "Ben")
val twos = FlashCard("What is 2 + 2?", "4")
val definition = FlashCard("What is the definition of love?", "an intense feeling of deep affection")

// TODO 2/4: Design the data type Deck to represent a deck of
//           flash cards. The deck should have a name, as well
//           as a sequence of flash cards.
//
//           Include at least 2 example decks based upon the
//           card examples above.
//
data class Deck(val name: String, val cards: List<FlashCard>)
val deckOne = Deck("Normal Deck", listOf(name, twos, definition))
val deckTwo = Deck("Reverse Deck", listOf(definition, twos, name))

// TODO 3/4: Design the predicate areAllOneWordAnswers that
//           determines if the backs of all the cards in a deck
//           are a single word (i.e., have no spaces, which
//           includes a card with a blank back).
//
//           Hint: hidden in the name of this function is a
//                 reminder of a useful list function to use :)
//

fun areAllOneWordAnswers(card: FlashCard): Boolean {
    return !(card.back.contains(" "))
}
// A couple potentially helpful examples for tests
val fcEmptyBack = FlashCard("Front", "")
val fcLongBack = FlashCard("Front", "Long answer")

testSame(areAllOneWordAnswers(fcEmptyBack), true)
testSame(areAllOneWordAnswers(fcLongBack), false)

// TODO 4/4: Design the predicate anyContainsPhrase that determines
//           if any of the cards in a deck contain the supplied
//           phrase
//
//           Hints:
//           - string1.contains(string2) will be quite useful
//             here :)
//           - Again, the name of this function hints at a useful
//             list function we learned!
//
val phrase = "Ben"

fun anyContainsPhrase(card: FlashCard): Boolean {
    return (card.front.contains(phrase)) || (card.back.contains(phrase))
}

testSame(deckOne.cards.any(::anyContainsPhrase), true)
