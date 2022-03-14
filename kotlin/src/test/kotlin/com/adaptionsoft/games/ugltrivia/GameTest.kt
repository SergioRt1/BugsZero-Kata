package com.adaptionsoft.games.ugltrivia

import com.adaptionsoft.games.uglytrivia.Game
import com.adaptionsoft.games.uglytrivia.addLast
import com.adaptionsoft.games.uglytrivia.removeFirst
import junit.framework.Assert
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class GameTest {

    private lateinit var out: PrintStream

    @Before
    fun setUp() {
        out = System.out
    }

    @After
    fun tearDown() {
        System.setOut(out)
    }

    @Test
    fun `is playable with one player should be false`() {
        val game = Game()
        game.add("Juan")

        val actual = game.isPlayable

        Assert.assertEquals(false, actual)
    }

    @Test
    fun `is playable with more than two player should be true`() {
        val game = Game()

        game.add("Juan")
        game.add("Pepe")
        val actual = game.isPlayable

        Assert.assertEquals(true, actual)
    }

    @Test
    fun `createRockQuestion should work`() {
        val game = Game()

        val actual = game.createRockQuestion(10)

        Assert.assertEquals("Rock Question 10", actual)
    }

    @Test
    fun `add player message should work`() {
        val game = Game()
        val resultStream = ByteArrayOutputStream()
        System.setOut(PrintStream(resultStream))

        game.add("Juan")

        Assert.assertEquals("Juan was added\nThey are player number 1\n", resultStream.toString())
    }

    @Test
    fun `add player should work`() {
        val game = Game()

        val isOk = game.add("Juan")

        Assert.assertEquals(true, isOk)
        Assert.assertEquals(1, game.players.size)
    }

    @Test
    fun `howManyPlayers should work`() {
        val game = Game()

        game.add("Juan")
        game.add("Pepe")
        val actual = game.howManyPlayers()

        Assert.assertEquals(2, actual)
    }

    @Test
    fun `howManyPlayers should work with no player`() {
        val game = Game()

        val actual = game.howManyPlayers()

        Assert.assertEquals(0, actual)
    }

    @Test
    fun `roll message should work`() {
        val game = Game()
        game.add("Juan")
        val resultStream = ByteArrayOutputStream()
        System.setOut(PrintStream(resultStream))

        game.roll(1)

        val expectedMessage = """
            Juan is the current player
            They have rolled a 1
            Juan's new location is 1
            The category is Science
            Science Question 0
            """.trimIndent() + '\n'
        Assert.assertEquals(expectedMessage, resultStream.toString())
    }

    @Test
    fun `roll message should work in penalty box`() {
        val game = Game()
        game.add("Juan")
        game.inPenaltyBox[0] = true
        val resultStream = ByteArrayOutputStream()
        System.setOut(PrintStream(resultStream))

        game.roll(1)

        val expectedMessage = """
            Juan is the current player
            They have rolled a 1
            Juan is getting out of the penalty box
            Juan's new location is 1
            The category is Science
            Science Question 0
            """.trimIndent() + '\n'
        Assert.assertEquals(expectedMessage, resultStream.toString())
    }

    @Test
    fun `removeFirst should work`() {
        val list = mutableListOf("Juan", "David")

        list.removeFirst()

        Assert.assertEquals(mutableListOf("David"), list)
    }

    @Test
    fun `addLast should work`() {
        val list = mutableListOf("Juan")

        list.addLast("David")

        Assert.assertEquals(mutableListOf("Juan", "David"), list)
    }
}