class Student(
    var rollNo: Int,
    var name: String,
    var course: String,
    var percentage: Double
) {
    fun updateData(newName: String, newCourse: String, newPercentage: Double) {
        name = newName
        course = newCourse
        percentage = newPercentage
    }

    fun display() {
        println("Roll No   : $rollNo")
        println("Name      : $name")
        println("Course    : $course")
        println("Percentage: $percentage%")
        println("----------")
    }
}

val s1 = Student(1, "harsh", "CSE", 88.5)
val s2 = Student(2, "mayank", "IT", 72.0)

println("=== Initial Details ===")
s1.display()
s2.display()

s1.updateData("harsh panchal", "CSE", 91.0)
s2.updateData("Bob dash", "IT", 78.5)

println("=== After Update ===")
s1.display()
s2.display()
