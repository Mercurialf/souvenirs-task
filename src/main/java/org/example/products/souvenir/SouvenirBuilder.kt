package org.example.products.souvenir

import java.time.LocalDate

class SouvenirBuilder {
    private var name: String = "Default"
    private var manufacturer: String = "Default"
    private var releaseDate: LocalDate = LocalDate.of(1900, 1, 1)
    private var price: Double = 0.0

    fun setName(name: String): SouvenirBuilder {
        this.name = name
        return this
    }

    fun setManufacturer(manufacturer: String): SouvenirBuilder {
        this.manufacturer = manufacturer
        return this
    }

    fun setReleaseDate(releaseDate: LocalDate): SouvenirBuilder {
        this.releaseDate = releaseDate
        return this
    }

    fun setPrice(price: Double): SouvenirBuilder {
        this.price = price
        return this
    }

    fun build(): Souvenir {
        return Souvenir(name, manufacturer, releaseDate, price)
    }
}