// -----------------------------------------------------------------
// Homework 2, Problem 4
// -----------------------------------------------------------------
import khoury.CapturedResult
import khoury.EnabledTest
import khoury.captureResults
import khoury.reactConsole
import khoury.testSame

// Now it's time to write your first full, if not a bit silly, app!
//
// TODO 1/1: Finish designing the program loopSong, using
//           reactConsole, that prints...
//
//           A-B-C
//
//           then...
//
//           Easy as 1-2-3
//
//           repeatedly until the user types "done" in response
//           to "Easy as 1-2-3", at which point the program
//           prints...
//
//           Baby you and me girl!
//
//           and returns the number of times the song looped
//           (meaning, how many times it printed "Easy as 1-2-3").
//
//           To help, you have an enumeration that represents the
//           beginning of the song, and each subsequent situation.
//           You also have tests - you just need to finish
//           loopSong, as well as designing the helper functions
//           that handle each type of event.
//
//           Suggestions:
//           - First, design how you will represent the state of
//             your program; SongState is useful, but you'll also
//             need to keep track of how many times the song looped
//             (hmm... more than piece of data in a single value,
//             what helps us there?).
//           - Next, have loopSong call reactConsole, providing
//             the initial state (ideally an example), and a set
//             of yet-to-be-designed helper functions, not
//             forgetting to return the number of song loops.
//           - Now, figure out the parameter/return types of each
//             helper, based upon how reactConsole works with your
//             data design.
//           - Then, write some tests to capture how these helper
//             functions *should* operate...
//             * songStateToText: should be producing the
//                                appropriate lyrics based on the
//                                situation (irrespective of loop
//                                count).
//             * nextSongState: should be figuring out what is the
//                              next situation based upon the
//                              current situation and what was
//                              typed (which matters only when
//                              "Easy as 1-2-3" was printed).
//             * isDone: should only return true when the current
//                       situation is that the song is done!
//            - And lastly, write the code for your helpers (as
//              informed by the types they use and tests!). You
//              might do these last two steps for each helper
//              individually; you can then test piece-by-piece if
//              you comment-out our tests and loopSong.
//
//           As with any interactive program, feel free to debug
//           by directly calling your program in main!
//

val LYRICS_ABC = "A-B-C"
val LYRICS_123 = "Easy as 1-2-3"
val LYRICS_DONE = "Baby you and me girl!"

data class State(val songState: SongState, val loops: Int)
val startState = State(SongState.ABC, 0)

// Represents state in the song
// (no changes here)
enum class SongState {
    START,
    ABC,
    EASY123,
    DONE,
}

fun loopSong(): Int {
    return reactConsole(
        initialState = startState,
        stateToText = ::songStateToText,
        nextState = ::nextSongState,
        isTerminalState = ::isDone,
    ).loops
}

fun songStateToText(state: State): String { // returns the text version of the current state
    return when (state.songState) {
        SongState.DONE -> LYRICS_DONE
        SongState.EASY123 -> LYRICS_123
        SongState.START -> LYRICS_ABC
        else -> LYRICS_ABC
    }
}

fun nextSongState(
    state: State,
    typedInput: String,
): State {
    return when ((typedInput.lowercase() == "done") && (state.songState == SongState.EASY123)) {
        true -> State(SongState.DONE, state.loops + 1)
        false -> return when (state.songState) {
            SongState.ABC -> State(SongState.EASY123, state.loops)
            else -> State(SongState.ABC, state.loops + 1)
        }
    }
}

fun isDone(state: State): Boolean { // returns whether the user typed done or not
    return state.songState == SongState.DONE
}

@EnabledTest
fun testLoopSong() {
    testSame(
        captureResults(
            ::loopSong,
            "",
            "done",
        ),
        CapturedResult(
            1,
            LYRICS_ABC,
            LYRICS_123,
            LYRICS_DONE,
        ),
        "quick",
    )

    testSame(
        captureResults(
            ::loopSong,
            "a",
            "b",
            "done",
            "c",
            "d",
            "done",
        ),
        CapturedResult(
            3,
            LYRICS_ABC,
            LYRICS_123,
            LYRICS_ABC,
            LYRICS_123,
            LYRICS_ABC,
            LYRICS_123,
            LYRICS_DONE,
        ),
        "longer",
    )
}

testLoopSong()
