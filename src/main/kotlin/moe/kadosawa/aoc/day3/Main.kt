package moe.kadosawa.aoc.day3

import moe.kadosawa.aoc.Solution
import moe.kadosawa.aoc.input

class Main : Solution {
    private val input = input("input3.txt")!!.readLines()
    private val normalInput = MutableList(input.first().length) { MutableList<Char?>(input.size) { null } }

    init {
        input.forEachIndexed { i, row ->
            for (j in row.indices) {
                normalInput[j][i] = input[i][j]
            }
        }
    }

    override fun part1() {
        var gammaRate = ""
        var epsilonRate = ""

        normalInput.forEach { bits ->
            var zeros = 0
            var ones = 0

            bits.forEach { bit ->
                if (bit == '0') {
                    zeros++
                }
                if (bit == '1') {
                    ones++
                }
            }

            if (zeros > ones) {
                gammaRate += "0"
                epsilonRate += "1"
            } else {
                gammaRate += "1"
                epsilonRate += "0"
            }
        }

        println("Part 1: ${gammaRate.toInt(2) * epsilonRate.toInt(2)}")

    }

    override fun part2() {
        var oxygenRating = input("input3.txt")!!.readLines()
        oxygenBruteforce@ for (i in 0 until oxygenRating.first().length) {
            var zeros = 0
            var ones = 0

            oxygenRating.forEach { line ->
                if (line[i] == '0') {
                    zeros++
                } else if (line[i] == '1') {
                    ones++
                }
            }

            val mostCommon = if (ones >= zeros) {
                '1'
            } else {
                '0'
            }

            if (oxygenRating.size == 1) {
                break@oxygenBruteforce
            }

            oxygenRating = oxygenRating.filter { it[i] == mostCommon }
        }

        var scrubberRating = input("input3.txt")!!.readLines()
        scrubberBruteforce@ for (i in 0 until scrubberRating.first().length) {
            var zeros = 0
            var ones = 0

            scrubberRating.forEach {line ->
                if (line[i] == '0') {
                    zeros++
                } else if (line[i] == '1') {
                    ones++
                }
            }

            val leastCommon = if (zeros <= ones) {
                '0'
            } else {
                '1'
            }

            if (scrubberRating.size == 1) {
                break@scrubberBruteforce
            }

            scrubberRating = scrubberRating.filter { it[i] == leastCommon }
        }

        println("Part 2: ${oxygenRating.first().toUInt(2) * scrubberRating.first().toUInt(2)}")
    }

    override fun run() {
        part1()
        part2()
    }
}