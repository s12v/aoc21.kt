fun main() {
    fun part1(depths: List<String>) =
        depths.map { it.toInt() }.windowed(size = 2).count { it[0] < it[1] }

    fun part2(depths: List<String>) =
        depths
            .asSequence()
            .map { it.toInt() }
            .windowed(size = 3)
            .map { it.sum() }
            .windowed(size = 2)
            .count { it[0] < it[1] }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
