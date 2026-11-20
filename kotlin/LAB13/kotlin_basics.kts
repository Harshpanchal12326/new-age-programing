println("Hello Kotlin!!!")


val name = "harsh"
val dept = "cs"
val years = 4
val salary = 90000.0

val bonus = when {
    dept == "cs" && years > 5 -> salary * 0.20
    dept == "HR" && years > 3 -> salary * 0.15
    else                      -> salary * 0.10
}

println("Employee: $name | Dept: $dept | Years: $years")
println("Bonus: $bonus")


val number = 12345
val digits = number.toString().map { it.digitToInt() }
val avg = digits.average()

println("Number: $number")
println("Digits: $digits")
println("Average of digits: $avg")
