package org.example.menu.commands.editing

import org.example.data.FileManager
import org.example.menu.Command
import org.example.products.SouvenirCollection
import org.example.products.manufacturer.ManufacturerBuilder
import org.example.products.souvenir.SouvenirBuilder
import org.example.utility.Config
import java.time.LocalDate
import java.util.*

class Add : Command {
    override fun execute() {
        println("*** Добавить сувенир или производителя. ***")
        val souvenirCollection = SouvenirCollection()
        when (choice()) {
            0 -> addManufacturer(souvenirCollection)
            1 -> addSouvenir(souvenirCollection)
        }
    }

    private fun choice(): Int {
        println("Введите '0' чтобы добавить производителя, и '1' чтобы добавить сувенир.")
        val scanner = Scanner(System.`in`)
        return scanner.nextInt()
    }

    private fun addSouvenir(souvenirCollection: SouvenirCollection) {
        println("Введите имя, производителя, дату выпуска и цену:")
        val scanner = Scanner(System.`in`)
        val info = scanner.nextLine().split(" ")
        val souvenir = SouvenirBuilder()
            .setName(info[0])
            .setManufacturer(info[1])
            .setReleaseDate(LocalDate.parse(info[2]))
            .setPrice(info[3].toDoubleOrNull() ?: 0.0)
            .build()
        souvenirCollection.addSouvenir(souvenir)
        saveChange(souvenirCollection)
    }

    private fun addManufacturer(souvenirCollection: SouvenirCollection) {
        println("Введите имя и страну производителя:")
        val scanner = Scanner(System.`in`)
        val info = scanner.nextLine().split(" ")
        val manufacturer = ManufacturerBuilder()
            .setName(info[0])
            .setCountry(info[1])
            .build()
        souvenirCollection.addManufacturer(manufacturer)
        saveChange(souvenirCollection)
    }

    private fun saveChange(souvenirCollection: SouvenirCollection) {
        FileManager.saveManufacturersToFile(
            Config.DEFAULT_MANUFACTURER_TEXT_FILE,
            souvenirCollection.manufacturerList
        )
        FileManager.saveSouvenirsToFile(
            Config.DEFAULT_SOUVENIR_TEXT_FILE,
            souvenirCollection.souvenirList
        )
        println("Изменения сохранены.")
    }
}