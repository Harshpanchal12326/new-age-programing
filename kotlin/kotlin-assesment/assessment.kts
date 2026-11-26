data class Product(val id: Int, val name: String, val category: String, val price: Double, val desc: String? = null)

fun Product.details() = "$id. $name ($category) - Rs.$price | ${desc ?: "No description"}"
fun Product.isExpensive() = if (price > 1000.0) "$name is Expensive" else "$name is Affordable"

class Store { var name = "My Store"; val products = mutableListOf<Product>()
    fun product(id: Int, n: String, cat: String, price: Double, desc: String? = null) = products.add(Product(id, n, cat, price, desc))
}

fun store(block: Store.() -> Unit): Store { val s = Store(); s.block(); return s }

val shop = store {
    name = "Campus Shop"
    product(1, "Mouse",      "Electronics", 550.0,  "Wireless mouse")
    product(2, "Keyboard",   "Electronics", 1200.0, "USB keyboard")
    product(3, "Notebook",   "Stationery",  100.0)
    product(4, "Pen Pack",   "Stationery",  150.0)
    product(5, "Headphones", "Electronics", 1500.0, "Wired headphones")
}

val p = shop.products
    
println("Store: ${shop.name}")
println("\nAll Products:")
p.forEach { println(it.details()) }

println("\nUnder Rs.1000:")
p.filter { it.price < 1000.0 }.forEach { println("${it.name} - Rs.${it.price}") }

println("\nAll Prices: ${p.map { it.price }}")
println("Total: Rs.${p.map { it.price }.reduce { a, b -> a + b }}")

println("\nBy Category:")
p.groupBy { it.category }.forEach { (cat, items) -> println("$cat: ${items.map { it.name }}") }

println("\nExpensive Check:")
p.forEach { println(it.isExpensive()) }
