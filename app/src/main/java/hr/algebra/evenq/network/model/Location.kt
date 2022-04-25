package hr.algebra.evenq.network.model

data class Location(
    val idLocation: Int,
    val city: String,
    val street: String,
    val coordinates: String
) {
}