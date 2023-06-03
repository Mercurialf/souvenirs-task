package org.example.menu.commands.editing

import org.example.data.FileManager
import org.example.menu.Command
import org.example.products.SouvenirCollection
import org.example.utility.Config

class Remove : Command {
    override fun execute() {
        println("*** Удалить производителя и сувениры. ***")
        val souvenirCollection = SouvenirCollection()
        souvenirCollection.deleteManufacturerAndSouvenirs(getManufacturerName())
        saveChange(souvenirCollection)
    }

    private fun getManufacturerName(): String {
        println("Введите название производителя: ")
        return readlnOrNull() ?: ""
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