package org.example.products.manufacturer

class ManufacturerBuilder {
    private var name: String = "Default"
    private var country: String = "Default"

    fun setName(name: String): ManufacturerBuilder {
        this.name = name
        return this
    }

    fun setCountry(country: String): ManufacturerBuilder {
        this.country = country
        return this
    }

    fun build(): Manufacturer {
        return Manufacturer(name, country)
    }
}