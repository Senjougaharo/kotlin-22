package Archive

import Notes.Notes
import Notes.NotesMenu
import java.util.*

class ArchiveMenu {

    val archive: MutableList<Archive> = mutableListOf(
        Archive("Создать архив:", mutableListOf()),
        Archive("Завершение работы", mutableListOf())
    )


    val notes = NotesMenu()

    fun addArchive() {
        println("Введите название:")
        val userInput = Scanner(System.`in`).nextLine()
        archive.add(archive.size - 1, Archive(userInput, mutableListOf()))
    }
    fun showArchiveMenu() {

        println("Архивы")
        for(z in 0..archive.lastIndex) {
            println("$z. ${archive[z].name}")
        }
    }
    fun interactWithArchive(): MutableList<Notes> {
        while (true) {

            try {
                showArchiveMenu()
                val userInput = Scanner(System.`in`).nextInt()
                if (userInput > archive.size - 1) {
                    println("Пожалуйста выберите действие из списка ниже:")
                    continue
                }

                when (userInput) {
                    0 -> addArchive()
                    archive.size - 1 -> System.exit(0)
                    else -> notes.notesInteractions(archive[userInput].notes)
                }
            } catch (v: InputMismatchException) {

                println("Пожалуйста выберите действие из списка ниже:")
            }
        }
    }
}