sealed class CommandsForConsole: Command {

    class Exit(): CommandsForConsole() {
        override fun isValid(input: List<String>): Boolean {
            return input.size == 1 && input[0].lowercase() == "exit"
        }

        fun exit(): Boolean{
            println("До встречи")
            return false
        }
    }

    class Help(): CommandsForConsole() {
        override fun isValid(input: List<String>): Boolean {
            return input.size == 1 && input[0].lowercase() ==  "help"
        }

        fun help(){
            val textHelp = "Список команд:\n" +
                    "'help' - вызвать меня повторно\n" +
                    "'show' - последний добавленный контакт\n" +
                    "'add <Имя> phone <Номер телефона>' - добавить контакт и его номер\n" +
                    "'add <Имя> email <Адрес электронной почты>' - добавить контакт и его почту\n" +
                    "'exit' - выйти из программы\n"
            println(textHelp)
        }
    }

    class AddPhone(): CommandsForConsole() {
        override fun isValid(input: List<String>): Boolean {
            val regexPhone = Regex("""^\+?\d{2,12}$""")
            return input[0].lowercase() ==  "add" && input[3].matches(regexPhone)
        }

        fun addPhone(input: List<String>, phoneBook: PhoneBook){
//            if (phoneBook.getContact(input[1]) == null){
//                var person = Person(_name = input[1], _phone = mutableListOf(input[3]), _email = mutableListOf())
//                phoneBook.addContact(person)
//            }
            var person = phoneBook.getContact(input[1])
            if (person == null){
                var newPerson = Person(_name = input[1], _phone = mutableListOf(input[3]), _email = mutableListOf())
                phoneBook.addContact(newPerson)
            } else {
                person.setPhone(input[3])
            }
        }
    }

    class AddEmail() : CommandsForConsole() {
        override fun isValid(input: List<String>): Boolean {
            val regexMail = Regex("""^[\w-.]+@([\w-]+\.)+[\w-]{2,4}$""")
            return input[0].lowercase() ==  "add" && input[3].matches(regexMail)
        }

        fun addEmail(input: List<String>, phoneBook: PhoneBook){
            var person = phoneBook.getContact(input[1])
            if (person == null){
                var newPerson = Person(_name = input[1], _phone = mutableListOf(), _email = mutableListOf(input[3]))
                phoneBook.addContact(newPerson)
            } else {
                person.setEmail(input[3])
            }
        }
    }

    class Show() : CommandsForConsole(){
        override fun isValid(input: List<String>): Boolean {
            return input.size == 2 && input[0].lowercase() == "show"
        }

        fun show(input: List<String>, phoneBook: PhoneBook){
            println(phoneBook.getContact(input[1])?: println("Контакт не найден"))
        }

        fun showFullPhoneBook(phoneBook: PhoneBook){
            phoneBook.getPhoneBook().forEach { el ->
                println(el)
            }
        }
    }

    class Find() : CommandsForConsole(){
        override fun isValid(input: List<String>): Boolean {
            return input.size == 2 && input[0].lowercase() == "find"
        }
        fun find (input: List<String>, phoneBook: PhoneBook){
            phoneBook.findByData(input[1]).let { result ->
                if (result.isNotEmpty()) result.forEach { el -> println(el) }
                else println("Ничего не найдено.")
            }
        }
    }
}