
fun main() {
    println("Здравствуйте")
    mainMenu()
}

fun mainMenu() {
    var run = true
    var phoneBook: MutableMap <String, MutableList<String>> = mutableMapOf()
    while (run) {
        val textMainMenu = "Введите команду:"
        println(textMainMenu)
        val input = readln()
        if (input == "exit") run=exit()
        else if (input == "help") help()
        else if (input.contains("add")) addOption(input, phoneBook)
        else println("не корректная команда")
    }
}

fun addOption(info: String, phonebook: MutableMap<String,MutableList<String>>) {
    val parts = info.split(" ")
    when(parts[2]){
        "phone" -> addPhone(parts, phonebook)
        "email" -> addMail(parts, phonebook)
        else -> println("не корректное добавление")
    }
}

fun addPhone(info: List<String>, phonebook: MutableMap<String,MutableList<String>>){
    val regexPhone = Regex("""^\+?\d{2,12}$""")
    if (info[3].matches(regexPhone)){
        addContact(info, phonebook)
        println("номер добавлен")
    }
    else println("не корректный номер")
}

fun addMail(info: List<String>, phonebook: MutableMap<String,MutableList<String>>){
    val regexMail = Regex("""^[\w-.]+@([\w-]+\.)+[\w-]{2,4}$""")
    if (info[3].matches(regexMail)) {
        addContact(info, phonebook)
        println("почта добавлена")
    }
    else println("не корректный email")
}

fun exit(): Boolean{
    println("До встречи")
    return false
}

fun help(){
    val textHelp = "помогаю"
    println(textHelp)
}

fun addContact(info: List<String>, phonebook: MutableMap<String,MutableList<String>>){
    if (phonebook.containsKey(info[1])){
        val userdata = phonebook.getValue(info[1])
        userdata.addLast(info[3])
    } else {
        val list = mutableListOf<String>()
        list.add(info[3])
        phonebook[info[1]] = list
    }
}
