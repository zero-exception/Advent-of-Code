package moe.kadosawa.aoc.day2

import moe.kadosawa.aoc.Solution
import moe.kadosawa.aoc.input

enum class Direction {
    forward,
    up,
    down
}

class Main : Solution {
    private val commands = input("input2.txt")!!.readLines().map {
        val direction = it.split("\\s+".toRegex()).first()
        val distance = it.split("\\s+".toRegex()).last().toInt()

        Pair(Direction.valueOf(direction), distance)
    }

    override fun part1() {
        var x = 0
        var depth = 0

        commands.forEach {
            when (it.first) {
                Direction.forward -> {
                    x += it.second
                }
                Direction.up -> {
                    depth -= it.second
                }
                Direction.down -> {
                    depth += it.second
                }
            }
        }

        println("Part 1: ${x * depth}")
    }

    override fun part2() {
        var x = 0
        var depth = 0
        var aim = 0

        commands.forEach { (direction, distance) ->
            when (direction) {
                Direction.forward -> {
                    x += distance
                    depth += aim * distance
                }
                Direction.up -> {
                    aim -= distance
                }
                Direction.down -> {
                    aim += distance
                }
            }
        }

        println("Part 2: ${x * depth}")
    }

    override fun run() {
        part1()
        part2()
    }
}