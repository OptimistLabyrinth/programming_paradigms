package refactor_in_fp_paradigm_07

private data class shop_item(
    val name: String,
    val price: Int,
)

private var shopping_cart: MutableList<shop_item> = ArrayList()
private var shopping_cart_price_total = 0

private fun add_item_to_cart(cart: MutableList<shop_item>, name: String, price: Int) {
    shopping_cart = add_item(cart, name, price)
    calc_cart_price_total()
}

private fun add_item(cart: MutableList<shop_item>, name: String, price: Int): MutableList<shop_item> {
    val new_cart = cart.slice(0..cart.size - 1) as MutableList<shop_item>
    new_cart.add(shop_item(name, price))
    return new_cart
}

private fun calc_cart_price_total() {
    shopping_cart_price_total = calc_total(shopping_cart)
    set_cart_price_total_on_ui()
    update_shipping_icons()
    update_tax_ui()
}

private fun calc_total(cart: MutableList<shop_item>): Int {
    var price_total = 0
    for (i in 0..cart.size - 1) {
        val item = cart[i]
        price_total += item.price
    }
    return price_total
}

private fun set_cart_price_total_on_ui() {
    // *
}

private fun update_shipping_icons() {
    val buy_buttons = get_buy_button_icons()
    for (i in 0..buy_buttons.size - 1) {
        val button = buy_buttons[i]
        val item = button.item
        if (is_free_delivery_available(shopping_cart_price_total, item)) {
            button.show_free_shipping_icon()
        } else {
            button.hide_free_shipping_icon()
        }
    }
}

private fun is_free_delivery_available(cart_price_total: Int, item: shop_item): Boolean {
    return 20 <= item.price + cart_price_total
}

private class button(val label: String, val item: shop_item) {
    fun show_free_shipping_icon() {
        // *
    }

    fun hide_free_shipping_icon() {
        // *
    }
}

private fun get_buy_button_icons(): MutableList<button> {
    return mutableListOf(
        button("a", shop_item("item 1", 1)),
        button("b", shop_item("item 2", 2)),
        button("c", shop_item("item 3", 3))
    )
}

private fun update_tax_ui() {
    set_tax_dom(calc_tax(shopping_cart_price_total))
}

private fun calc_tax(amount: Int): Double {
    return amount * 0.1
}

private fun set_tax_dom(price_total: Double) {
    // *
}
