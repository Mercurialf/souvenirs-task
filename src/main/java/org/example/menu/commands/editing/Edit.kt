package org.example.menu.commands.editing

import org.example.data.FileManager
import org.example.menu.Command
import org.example.products.SouvenirCollection
import org.example.utility.Config
import java.time.LocalDate
import java.util.*

class Edit : Command {
    override fun execute() {
        println("*** Редактировать сувенир или производителя. ***")
        val souvenirCollection = SouvenirCollection()
        when (choice()) {
            0 -> editManufacturer(souvenirCollection)
            1 -> editSouvenir(souvenirCollection)
        }
        println()
    }

    private fun choice(): Int {
        println("Чтобы редактировать производителя, введите - '0', сувенир - '1':")
        return readlnOrNull()?.toIntOrNull() ?: 0
    }

    private fun editManufacturer(souvenirCollection: SouvenirCollection) {
        println("Введите имя производителя для редактирования:")
        val name = readlnOrNull() ?: ""
        println("Введите новое имя:")
        val newName = readlnOrNull() ?: ""
        println("Укажите страну производителя:")
        val country = readlnOrNull() ?: ""
        souvenirCollection.editManufacturer(name, newName, country)
        saveChange(souvenirCollection)
    }

    private fun editSouvenir(souvenirCollection: SouvenirCollection) {
        println("Введите имя и производителя сувенира:")
        val scanner = Scanner(System.`in`)
        val info = scanner.nextLine().split(" ")
        println("Введите новое имя, производителя, дату выпуска и цену:")
        val newInfo = scanner.nextLine().split(" ")
        souvenirCollection.editSouvenir(
            info[0], info[1],
            newInfo[0], newInfo[1],
            LocalDate.parse(newInfo[2]),
            newInfo[3].toDoubleOrNull() ?: 0.0
        )
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