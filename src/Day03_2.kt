fun main() {

    fun mostFrequentNthBit(readings: List<String>, n: Int) =
        if (readings.count { it[n] == '0' } <= readings.size / 2) '1' else '0'

    fun rating(input: List<String>, mostFrequent: Boolean): Int {
        var n = 0
        var readings = input
        while (readings.size > 1) {
            readings = readings.filter { mostFrequent xor (it[n] == mostFrequentNthBit(readings, n)) }
            n++
        }

        return readings.first().toInt(2)
    }

    fun part2(readings: List<String>): Int {
        val oxygenRating = rating(readings, mostFrequent = true)
        val co2Rating = rating(readings, mostFrequent = false)
        return oxygenRating * co2Rating
    }


    val testInput = readInput("Day03_test")
    check(part2(testInput) == 230)

    val input = readInput("Day03")
    println(part2(input))
}
