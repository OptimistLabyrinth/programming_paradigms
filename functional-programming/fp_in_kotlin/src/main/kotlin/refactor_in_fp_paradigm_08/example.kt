package refactor_in_fp_paradigm_08

private data class shop_item(
    val name: String,
    val price: Int,
)

private var shopping_cart: MutableList<shop_item> = ArrayList()

private fun add_item_to_cart(cart: MutableList<shop_item>, name: String, price: Int) {
    shopping_cart = add_item(cart, name, price)
    val total = calc_total(shopping_cart)
    set_cart_price_total_on_ui(total)
    update_shipping_icons(cart)
    update_tax_ui(total)
}

private fun add_item(cart: MutableList<shop_item>, name: String, price: Int): MutableList<shop_item> {
    val new_cart = cart.slice(0..cart.size - 1) as MutableList<shop_item>
    new_cart.add(shop_item(name, price))
    return new_cart
}

private fun calc_total(cart: MutableList<shop_item>): Int {
    var price_total = 0
    for (i in 0..cart.size - 1) {
        val item = cart[i]
        price_total += item.price
    }
    return price_total
}

private fun set_cart_price_total_on_ui(total: Int) {
    // *
}

private fun update_shipping_icons(cart: MutableList<shop_item>) {
    val buy_buttons = get_buy_button_icons()
    for (i in 0..buy_buttons.size - 1) {
        val button = buy_buttons[i]
        val item = button.item
        val new_cart = add_item(cart, item.name, item.price)
        set_free_shipping_icon(button, is_free_shipping_available(new_cart))
    }
}

private fun set_free_shipping_icon(button: item_button, isVisible: Boolean) {
    if (isVisible) {
        button.show_free_shipping_icon()
    } else {
        button.hide_free_shipping_icon()
    }
}

private fun is_free_shipping_available(cart: MutableList<shop_item>): Boolean {
    return 20 <= calc_total(cart)
}

private class item_button(val label: String, val item: shop_item) {
    fun show_free_shipping_icon() {
        // *
    }

    fun hide_free_shipping_icon() {
        // *
    }
}

private fun get_buy_button_icons(): MutableList<item_button> {
    return mutableListOf(
        item_button("a", shop_item("item 1", 1)),
        item_button("b", shop_item("item 2", 2)),
        item_button("c", shop_item("item 3", 3))
    )
}

private fun update_tax_ui(total: Int) {
    set_tax_dom(calc_tax(total))
}

private fun calc_tax(amount: Int): Double {
    return amount * 0.1
}

private fun set_tax_dom(price_total: Double) {
    // *
}
