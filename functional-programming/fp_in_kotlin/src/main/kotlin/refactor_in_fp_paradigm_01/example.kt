package refactor_in_fp_paradigm_01

private data class shop_item(
    val name: String,
    val price: Int,
)

private var shopping_cart: MutableList<shop_item> = ArrayList()
private var shopping_cart_price_total = 0

private fun add_item_to_cart(name: String, price: Int) {
    shopping_cart.add(shop_item(name, price))
    calc_cart_price_total()
}

private fun calc_cart_price_total() {
    shopping_cart_price_total = 0
    for (i in 0..shopping_cart.size - 1) {
        val item = shopping_cart[i]
        shopping_cart_price_total += item.price
    }
    set_cart_price_total_on_ui()
}

private fun set_cart_price_total_on_ui() {
    // *
}
