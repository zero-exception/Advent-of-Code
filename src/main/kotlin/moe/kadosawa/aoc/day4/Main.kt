package moe.kadosawa.aoc.day4

import moe.kadosawa.aoc.Solution
import moe.kadosawa.aoc.input

class Board(raw: String) {
    val twoDim = raw.split("\n").map { line ->
        line.trim()
            .split("""\s+""".toRegex())
            .map { it.toInt() }
    }

}

class Main : Solution {
    override fun part1() {
        val boards = input("4.txt")!!
            .readText()
            .split("\\r\\n".toRegex())
            .map { it.trim() }

        println(boards[1].isEmpty())
    }

    override fun part2() {

    }

    override fun run() {
        part1()
        part2()
    }
}