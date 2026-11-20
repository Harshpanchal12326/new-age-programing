
fun greet(name: String = "World", msg: String = "Hello") {
    println("$msg, $name!")
}

greet()
greet("Alice", "Hi")

// (2) Named arguments (out of order)
greet(msg = "Welcome", name = "Bob")


fun printAll(vararg nums: Int) {
    println("Numbers: ${nums.toList()}")
}

printAll(1, 2, 3, 4, 5)


fun applyToList(nums: List<Int>, op: (Int) -> Int): List<Int> {
    return nums.map { op(it) }
}

val numbers = listOf(1, 2, 3, 4, 5)
val doubled  = applyToList(numbers) { it * 2 }
val squared  = applyToList(numbers) { it * it }

println("Original : $numbers")
println("Doubled  : $doubled")
println("Squared  : $squared")
