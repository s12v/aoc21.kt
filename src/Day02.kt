fun main() {
    fun parse(it: String) =
        it.split(' ').let { it[0] to it[1].toInt() }.let { (direction, value) ->
            when (direction) {
                "forward" -> value to 0
                "up" -> 0 to -value
                "down" -> 0 to value
                else -> throw Exception("Unknown direction")
            }
        }

    fun part1(actions: List<String>) =
        actions
            .map { parse(it) }
            .fold(0 to 0) { (x, y), (dx, dy) -> x + dx to y + dy }
            .let { it.first * it.second }

    fun part2(actions: List<String>) =
        actions
            .map { parse(it) }
            .fold(Triple(0, 0, 0)) { (x, y, aim), (dx, dy) ->
                if (dy == 0) {
                    Triple(x + dx, y + aim * dx, aim)
                } else {
                    Triple(x, y, aim + dy)
                }
            }
            .let { it.first * it.second }


    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
