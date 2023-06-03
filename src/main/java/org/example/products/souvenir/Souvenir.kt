package org.example.products.souvenir

import java.time.LocalDate

data class Souvenir(
    var name: String,
    var manufacturer: String,
    var releaseDate: LocalDate,
    var price: Double
)