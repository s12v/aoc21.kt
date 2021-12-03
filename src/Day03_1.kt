fun main() {

    fun updateMap(map: MutableMap<Int, MutableMap<Int, Int>>, reading: String): MutableMap<Int, MutableMap<Int, Int>> {
        reading.indices.map { i ->
            i to Character.getNumericValue(reading[i])
        }.forEach { (i, v) ->
            map.putIfAbsent(i, mutableMapOf(0 to 0, 1 to 0))
            map[i]!![v] = map[i]!![v]!! + 1
        }
        return map
    }

    fun buildGreeks(map: Map<Int, MutableMap<Int, Int>>): Pair<Int, Int> {
        val gamma = StringBuilder()
        val epsilon = StringBuilder()
        for (i in 0 until map.size) {
            if (map[i]!![1]!! > map[i]!![0]!!) {
                gamma.append('1')
                epsilon.append('0')
            } else {
                gamma.append('0')
                epsilon.append('1')
            }
        }
        return gamma.toString().toInt(2) to epsilon.toString().toInt(2)
    }

    fun part1(readings: List<String>) =
        readings
            .fold(mutableMapOf<Int, MutableMap<Int, Int>>()) { map, reading -> updateMap(map, reading) }
            .let { map -> buildGreeks(map) }
            .let { (gamma, epsilon) -> gamma * epsilon }



    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)

    val input = readInput("Day03")
    println(part1(input))
}
