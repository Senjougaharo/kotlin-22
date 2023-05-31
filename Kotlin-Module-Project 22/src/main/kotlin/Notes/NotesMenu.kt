package Notes

import java.util.*

class NotesMenu {

    fun addNotes(menu: MutableList<Notes>) {
        println("Введите название:")
        val name = Scanner(System.`in`).nextLine()

        println("Введите текст:")

        val text = Scanner(System.`in`).nextLine()

        menu.add(menu.size - 1, Notes(name, text))
        println("Заметка успешно создана!")
    }


    fun showMenu(menu: MutableList<Notes>)  {
        println("Заметки")
        for(v in 0..menu.size - 1) {

            println("$v. ${menu.get(v).name}")
        }
    }


    fun notesInteractions(menu: MutableList<Notes>) {
        if (menu.size == 0) {

            menu.add(Notes("Создать заметку:", ""))
            menu.add(Notes("Выход", ""))
        }
        while (true) { try {

            showMenu(menu)
            val userInput = Scanner(System.`in`).nextInt()
            if (userInput > menu.size - 1) {
                println("Пожалуйста выберите действие из списка ниже:")
                continue
            }

            when (userInput) {

                0 -> addNotes(menu)
                menu.size - 1 -> return
                else -> println(menu.get(userInput).text)
            }
        } catch (v: InputMismatchException)
        {
            println("Пожалуйста выберите действие из списка ниже:")
        }
        }
    }

}