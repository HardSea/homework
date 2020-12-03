// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> = customers.filter {
    val (de, unde) = it.orders.partition { it.isDelivered == true }
    unde.size > de.size
}.toSet()
