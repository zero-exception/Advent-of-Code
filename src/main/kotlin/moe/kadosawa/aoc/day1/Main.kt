package moe.kadosawa.aoc.day1

import moe.kadosawa.aoc.Solution
import moe.kadosawa.aoc.input

class Main : Solution {
    private val input = input("input1.txt")
        ?.readLines()
        ?.map { it.toInt() }


    override fun part1() {
        var previous = Int.MAX_VALUE
        var count = 0

        input?.forEach {
            if (it > previous) {
                count++
            }
            previous = it
        }

        println(count)
    }

    override fun part2() {
        var previous = Int.MAX_VALUE
        var count = 0

        input?.forEachIndexed mainLoop@{ i, first ->
            if (i + 1 > input.size - 1 || i + 2 > input.size - 1) {
                return@mainLoop
            }

            val second = input[i + 1]
            val third = input[i + 2]

            val windowSum = first.plus(second).plus(third)
            if (windowSum > previous) {
                count++
            }

            previous = windowSum
        }

        println(count)
    }

    override fun run() {
        part1()
        part2()
    }
}
