package org.example.menu.commands.editing

import org.example.menu.Command
import org.example.products.SouvenirCollection
import java.util.*

class Show : Command {
    override fun execute() {
        println("*** Показать все сувениры и производителей. ***")
        val souvenirCollection = SouvenirCollection()
        when (choice()) {
            0 -> printAllManufacturers(souvenirCollection)
            1 -> printAllSouvenirs(souvenirCollection)
        }
    }

    private fun choice(): Int {
        println("Введите '0' для просмотра списка производителей, и '1' для просмотра списка сувениров.")
        return Scanner(System.`in`).nextInt()
    }

    private fun printAllSouvenirs(souvenirCollection: SouvenirCollection) {
        println("Список всех сувениров:")
        souvenirCollection.printAllSouvenirs()
        println()
    }

    private fun printAllManufacturers(souvenirCollection: SouvenirCollection) {
        println("Список всех производителей:")
        souvenirCollection.printAllManufacturer()
        println()
    }
}